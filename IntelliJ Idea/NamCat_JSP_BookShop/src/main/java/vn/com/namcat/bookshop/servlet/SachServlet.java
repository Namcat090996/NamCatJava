package vn.com.namcat.bookshop.servlet;

import vn.com.namcat.bookshop.entities.*;
import vn.com.namcat.bookshop.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SachServlet", value = "/SachServlet")
public class SachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Declare variables
        String maSach = "";
        boolean isDel = false;

        //Check if the book code is null
        if(request.getParameter("id") != null)
        {
            //Get book code
            maSach = request.getParameter("id");
        }

        //Check if book code is empty
        if(!maSach.isEmpty())
        {
            //Declare an object to call the functions
            SachDao sachDao = new SachImpl();

            //Get the function to delete a book
            isDel = sachDao.xoa(maSach);
        }

        //Return the main page
        if(isDel)
        {
            response.sendRedirect("QuanLySach.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set utf-8 and text/html for request and respone
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //Declare varibles
        boolean isInsert = true;
        String maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", sachId = "", maChuDe = "";
        int giaSach = 0;

        //Check if the book code is null/empty
        if(request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty()) {
            //Get book code
            sachId = "" + request.getParameter("hSachId");
        }

        //Get data from input
        maSach = request.getParameter("txtMaSach");
        tenSach = request.getParameter("txtTenSach");
        moTa = request.getParameter("txtMoTa");
        anhSach = request.getParameter("txtAnhSach");
        tacGia = request.getParameter("txtTacGia");
        maChuDe = request.getParameter("cboChuDe");
        giaSach = Integer.parseInt("" + request.getParameter("txtGiaSach"));

        //Declare book object
        Sach objSach = new Sach();

        //In case of updating book info
        if(!sachId.isEmpty())
        {
            //Update book info
            isInsert = false;

            //Reassign book code to book object
            objSach.setMaSach(sachId);
        }
        else //In case of adding a new book
        {
            //Assign a new book code to book object
            objSach.setMaSach(maSach);
        }

        //Assign values to book object
        objSach.setTenSach(tenSach);
        objSach.setMoTa(moTa);
        objSach.setAnhSach(anhSach);
        objSach.setTacGia(tacGia);
        objSach.setGiaSach(giaSach);
        objSach.setMaChuDe(maChuDe);

        //Declare an object to call an update/add function
        SachDao sachDao = new SachImpl();

        //Declare an return result
        boolean ketQua = false;

        //In case of adding a new  book
        if(isInsert)
        {
            objSach.setNgayTao(new Date());
            objSach.setNgayCapNhat(new Date());
            ketQua = sachDao.themMoi(objSach);
        }
        else //In case of updating book info
        {
            objSach.setNgayCapNhat(new Date());
            ketQua = sachDao.capNhat(objSach);
        }

        //Return to main page
        if(ketQua)
        {
            response.sendRedirect("QuanLySach.jsp");
        }
    }
}
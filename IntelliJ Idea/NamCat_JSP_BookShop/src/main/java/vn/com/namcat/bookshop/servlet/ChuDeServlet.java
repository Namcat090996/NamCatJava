package vn.com.namcat.bookshop.servlet;

import vn.com.namcat.bookshop.entities.*;
import vn.com.namcat.bookshop.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChuDeServlet", value = "/ChuDeServlet")
public class ChuDeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Declare variables
        String maChuDe = "";
        boolean isDel = false;

        //Check if the book code is null
        if(request.getParameter("id") != null)
        {
            //Get book code
            maChuDe = request.getParameter("id");
        }

        //Check if book code is empty
        if(!maChuDe.isEmpty())
        {
            //Declare an object to call the functions
            ChuDeDao chuDeDao = new ChuDeImpl();

            //Get the function to delete a book
            isDel = chuDeDao.xoa(maChuDe);
        }

        //Return the main page
        if(isDel)
        {
            response.sendRedirect("QuanLyChuDe.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set utf-8 for request and response
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        //Declare variables
        boolean isInsert = true;
        String chuDeId = "", maChuDe = "", tenChuDe = "";

        //Check if the request of subject code is null/empty
        if(request.getParameter("hChuDeId") != null && !request.getParameter("hChuDeId").isEmpty())
        {
            //Get subject code
            chuDeId = request.getParameter("hChuDeId");
        }

        //Get data from input
        maChuDe = request.getParameter("txtMaChuDe");
        tenChuDe = request.getParameter("txtTenChuDe");

        //Declare subject object
        ChuDe objChuDe = new ChuDe();

        //In case of updating subject info
        if (!chuDeId.isEmpty())
        {
            //Update subject info
            isInsert = false;

            //Reassign subject code to book object
            objChuDe.setMaChuDe(chuDeId);
        }
        else //In case of adding a new subject
        {
            //Assign a new subject code to book object
            objChuDe.setMaChuDe(maChuDe);
        }

        //Assign values to subject object
        objChuDe.setTenChuDe(tenChuDe);

        //Declare object to get add/update function\
        ChuDeDao chuDe = new ChuDeImpl();

        //Declare a return result
        boolean ketQua = false;

        //In case of adding a new subject
        if(isInsert)
        {
            ketQua = chuDe.themMoi(objChuDe);
        }
        else//In case of updating subject info
        {
            ketQua = chuDe.capNhat(objChuDe);
        }

        //Return the main page
        if(ketQua)
        {
            response.sendRedirect("QuanLyChuDe.jsp");
        }
    }
}
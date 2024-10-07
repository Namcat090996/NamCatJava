package vn.com.stanford.bst.servlet;

import vn.com.stanford.bst.entities.Sach;
import vn.com.stanford.bst.model.SachDao;
import vn.com.stanford.bst.model.SachImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SachServlet", value = "/SachServlet")
public class SachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //Set utf-8 for request and response
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        //Declare variables
//        boolean isInsert = true;
//        String maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", sachId = "";
//        int giaSach = 0;
//
//        //Check if book code is null
//        if(request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty())
//        {
//            //Get book code
//            sachId = "" + request.getParameter("hSachId");
//
//            //Get data from input
//            maSach = request.getParameter("txtMaSach");
//            tenSach = request.getParameter("txtTenSach");
//            moTa = request.getParameter("txtMoTa");
//            anhSach = request.getParameter("txtAnhSach");
//            tacGia = request.getParameter("txtTacGia");
//            giaSach = Integer.parseInt("" + request.getParameter("txtGiaSach"));
//
//            //Declare book object
//            Sach objSach = null;
//
//            //In case of update
//            if(!sachId.isEmpty())
//            {
//                isInsert = false;
//
//                //Instantiate the book object
//                objSach = new Sach();
//
//                //Assign book code to book object
//                objSach.setMaSach(sachId);
//            }
//            else //In case of adding a new book
//            {
//                //Get book code from input
//                objSach.setMaSach(maSach);
//            }
//
//            //Assign vales to book object
//            objSach.setTenSach(tenSach);
//            objSach.setMoTa(moTa);
//            objSach.setAnhSach(anhSach);
//            objSach.setTacGia(tacGia);
//            objSach.setGiaSach(giaSach);
//            objSach.setMaChuDe("TH");
//
//            //Declare an object
//            SachDao sachDao = new SachImpl();
//
//            //Declare a boolean
//            boolean ketQua = false;
//
//            //In case of adding a new book
//            if(isInsert)
//            {
//                objSach.setNgayTao(new Date());
//                objSach.setNgayCapNhat(new Date());
//                ketQua = sachDao.themMoi(objSach);
//            }
//            else //In case of update
//            {
//                objSach.setNgayCapNhat(new Date());
//                ketQua = sachDao.capNhat(objSach);
//            }
//
//            //Return to main page
//            if(ketQua)
//            {
//                response.sendRedirect("QuanLySach.jsp");
//            }
//        }

        //Set utf-8 for request and response
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //Declare variables
        boolean isInsert = true;
        String maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", sachId = "";
        int giaSach = 0;

        //Check if the book code is empty
        if (request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty()) {
            //Get book code
            sachId = request.getParameter("hSachId");


        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
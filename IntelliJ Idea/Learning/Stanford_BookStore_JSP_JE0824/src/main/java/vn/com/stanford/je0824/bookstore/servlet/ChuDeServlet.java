package vn.com.stanford.je0824.bookstore.servlet;

import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.model.ChuDeDao;
import vn.com.stanford.je0824.bookstore.model.ChuDeImpl;
import vn.com.stanford.je0824.bookstore.model.SachDao;
import vn.com.stanford.je0824.bookstore.model.SachImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChuDeServlet", value = "/ChuDeServlet")
public class ChuDeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maChuDe = "", tenChuDe = "";

        request.setCharacterEncoding("utf-8");

        maChuDe = request.getParameter("txtMaChuDe");
        tenChuDe = request.getParameter("txtTenChuDe");

        ChuDeDao chuDeDao = new ChuDeImpl();

        ChuDe objChuDe = null;
        boolean isInsert = true;

        if(!maChuDe.isEmpty())
        {
            objChuDe = chuDeDao.layChiTiet(maChuDe);
        }

        if(objChuDe!=null)
        {
            isInsert = false;
        }
        else
        {
            objChuDe = new ChuDe();
        }

        objChuDe.setMaChuDe(maChuDe);
        objChuDe.setTenChuDe(tenChuDe);

        boolean ketQua = false;

        if(isInsert == true)
        {
            ketQua = chuDeDao.themMoi(objChuDe);
        }
        else
        {
            ketQua = chuDeDao.capNhat(objChuDe);
        }

        response.sendRedirect("QuanLyChuDe.jsp");

    }
}
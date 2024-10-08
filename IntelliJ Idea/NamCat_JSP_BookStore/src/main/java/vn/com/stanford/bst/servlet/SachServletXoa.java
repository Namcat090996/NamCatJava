package vn.com.stanford.bst.servlet;

import vn.com.stanford.bst.model.SachDao;
import vn.com.stanford.bst.model.SachImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SachServletXoa", value = "/SachServletXoa")
public class SachServletXoa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Check if the book code is null
        if(request.getParameter("id") != null && !request.getParameter("id").isEmpty())
        {
            //Declare variables
            String maSach = "";

            //Declare a return result
            boolean isDel = false;

            //Get book code
            maSach = request.getParameter("id");

            //Declare object to call delete function
            SachDao sachDao = new SachImpl();

            if(maSach.length() != 0 && !maSach.isEmpty())
            {
                //Implement the delete function
                isDel = sachDao.xoa(maSach);

                if(isDel)
                {
                    response.sendRedirect("QuanLySach.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
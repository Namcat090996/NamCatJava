package vn.com.stanford.bst.servlet;

import vn.com.stanford.bst.model.ChuDeDao;
import vn.com.stanford.bst.model.ChuDeImpl;
import vn.com.stanford.bst.model.SachDao;
import vn.com.stanford.bst.model.SachImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChuDeServletXoa", value = "/ChuDeServletXoa")
public class ChuDeServletXoa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Check if the subject code is null
        if(request.getParameter("id") != null && !request.getParameter("id").isEmpty())
        {
            //Declare variables
            String maChuDe = "";

            //Declare a return result
            boolean isDel = false;

            //Get book code
            maChuDe = request.getParameter("id");

            //Declare object to call delete function
            ChuDeDao chuDe = new ChuDeImpl();

            if(maChuDe.length() != 0 && !maChuDe.isEmpty())
            {
                //Implement the delete function
                isDel = chuDe.xoa(maChuDe);

                if(isDel)
                {
                    response.sendRedirect("QuanLyChuDe.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
package vn.com.namcat.bookshop.servlet;

import vn.com.namcat.bookshop.entities.*;
import vn.com.namcat.bookshop.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GioHangServlet", value = "/GioHangServlet")
public class GioHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Declare variables
        String maSach = "";
        boolean isHangDaCo = false;

        //Check if the request of book code is null
        if(request.getParameter("id") != null)
        {
            //Get book code
            maSach = request.getParameter("id");

            //Declare a session
            HttpSession session = request.getSession(true);

            //Declare a book list in session
            List<Sach> lstSach = new ArrayList<Sach>();

            if(session != null && session.getAttribute("gioHang") != null)
            {
                //Get the book list in session if existed

            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
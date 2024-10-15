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

        //Check if the request of book code is null
        if(request.getParameter("id") != null)
        {
            //Declare variables
            String maSach = "";

            //Get book code
            maSach = request.getParameter("id");

            //Declare an object to call functions
            SachDao sachDao = new SachImpl();

            //Get the detailed book object by book code
            Sach objSach = sachDao.layChiTiet(maSach);

            if(objSach != null)
            {
                //Declare variables
                boolean isHangDaCo = false;

                //Declare a session
                HttpSession session = request.getSession(true);

                //Declare a book list in session
                List<Sach> lstSach = new ArrayList<Sach>();

                if(session != null && session.getAttribute("gioHang") != null)
                {
                    //Get the book list in session if existed
                    lstSach = (List<Sach>)session.getAttribute("gioHang");

                    //Check if the book code already exists in the shopping cart
                    for(int i = 0; i < lstSach.size(); i++)
                    {
                        if(lstSach.get(i).getMaSach() == maSach)
                        {
                            //Set the quantities for book object
                            objSach.setSoLuong(lstSach.get(i).getSoLuong() + 1);

                            //Add book object to book list again
                            lstSach.set(i, objSach);

                            //The book is already in shopping cart
                            isHangDaCo = true;
                        }
                    }
                    if(isHangDaCo == false) //The book isn't currently in shopping cart
                    {
                        //Set the quantities for book object
                        objSach.setSoLuong(1);

                        //Insert book object into book list
                        lstSach.add(objSach);
                    }
                }
                else
                {
                    //Set the quantities for book object
                    objSach.setSoLuong(1);

                    //Insert book object into book list
                    lstSach.add(objSach);
                }

                //Save book list to "gioHang" attribute in session
                session.setAttribute("gioHang", lstSach);

                //Return the main page
                response.sendRedirect("TrangChu.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
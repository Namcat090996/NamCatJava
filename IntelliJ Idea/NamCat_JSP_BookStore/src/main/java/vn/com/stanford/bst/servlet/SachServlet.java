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
    /**
     * Xử lý xóa thông tin sách
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     * Xử lý thêm mới hoặc cập nhật thông tin sách
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set utf-8 for request and response
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //Declare variables
        boolean isInsert = true;
        String maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", sachId = "", maChuDe = "";
        int giaSach = 0;

        //Check if the book code is null/empty
        if (request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty()) {
            //Get book code
            sachId = "" + request.getParameter("hSachId");
        }

            //Get data from input
            maSach = request.getParameter("txtMaSach");
            tenSach = request.getParameter("txtTenSach");
            moTa = request.getParameter("txtMoTa");
            anhSach = request.getParameter("txtAnhSach");
            tacGia = request.getParameter("txtTacGia");
            giaSach = Integer.parseInt("" + request.getParameter("txtGiaSach"));
            maChuDe = request.getParameter("cboChuDe");

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
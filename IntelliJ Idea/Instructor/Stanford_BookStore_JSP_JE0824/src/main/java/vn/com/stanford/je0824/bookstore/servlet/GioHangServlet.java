package vn.com.stanford.je0824.bookstore.servlet;

import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.model.SachDao;
import vn.com.stanford.je0824.bookstore.model.SachImpl;

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

        String maSach = "";
        boolean isHangDaCo = false;

        if(request.getParameter("id") != null)
        {
            maSach = "" + request.getParameter("id");

            SachDao sachDao = new SachImpl();

            Sach objSach = sachDao.layChiTiet(maSach);

            if(objSach != null)
            {
                List<Sach> lstSach = new ArrayList<Sach>();

                HttpSession session = request.getSession(true);

                if(session != null && session.getAttribute("gioHang") != null)
                {
                    lstSach = (List<Sach>) session.getAttribute("gioHang");

                    for(int i = 0; i < lstSach.size(); i++)
                    {
                        if(lstSach.get(i).getMaSach() == maSach)
                        {
                            objSach.setSoLuong(lstSach.get(i).getSoLuong() + 1);
                            lstSach.set(i, objSach);
                            isHangDaCo = true;
                        }
                    }

                    if(isHangDaCo == false)
                    {
                        objSach.setSoLuong(1);
                        lstSach.add(objSach);
                    }
                }
                else
                {
                    objSach.setSoLuong(1);
                    lstSach.add(objSach);
                }

                session.setAttribute("gioHang", lstSach);

                response.sendRedirect("TrangChu.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
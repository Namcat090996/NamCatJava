package vn.com.stanford.je082401.amthuc.servlet;

import vn.com.stanford.je082401.amthuc.entities.MonAn;
import vn.com.stanford.je082401.amthuc.model.MonAnDao;
import vn.com.stanford.je082401.amthuc.model.MonAnImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "MonAnServlet", value = "/MonAnServlet")
public class MonAnServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenMonAn = "" + request.getParameter("id");

        if(!tenMonAn.isEmpty())
        {
            MonAnDao monAnDao = new MonAnImpl();

            //Thực hiện xóa
            boolean ketQua = monAnDao.xoa(tenMonAn);

            if(ketQua)
            {
                response.sendRedirect("QuanLyMonAn.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //Khai báo biến
        boolean isInsert = true;
        String monAnId = "", tenMonAn = "", moTa = "", noiDung = "", anhMonAn = "", chuDe = "";

        if(request.getParameter("hMonAnId") != null && !request.getParameter("hMonAnId").isEmpty())
            monAnId = "" + request.getParameter("hMonAnId");

        tenMonAn = request.getParameter("txtTenMonAn");
        moTa = request.getParameter("txtMoTa");
        noiDung = request.getParameter("txtNoiDung");
        anhMonAn = request.getParameter("txtAnhMonAn");
        chuDe = request.getParameter("txtChuDe");

        //Khai báo 1 đối tượng
        MonAn objMonAn;
        objMonAn = new MonAn();

        if(!monAnId.isEmpty())
        {
            isInsert = false;
            objMonAn.setTenMonAn(monAnId);
        }
        else
        {
            objMonAn.setTenMonAn(tenMonAn);
        }

        //Gán giá trị cho các thuộc tính
        objMonAn.setMoTa(moTa);
        objMonAn.setNoiDung(noiDung);
        objMonAn.setAnhMonAn(anhMonAn);
        objMonAn.setChuDe(chuDe);

        boolean ketQua = false;

        MonAnDao monAnDao = new MonAnImpl();

        if(isInsert)
        {
            objMonAn.setNgayTao(new Date());
            objMonAn.setNgayCapNhat(new Date());
            ketQua = monAnDao.themMoi(objMonAn);
        }
        else
        {
            objMonAn.setNgayCapNhat(new Date());
            ketQua = monAnDao.capNhat(objMonAn);
        }

        if(ketQua)
        {
            response.sendRedirect("QuanLyMonAn.jsp");
        }
    }
}
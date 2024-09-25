package vn.com.stanford.je0824.workingwithservlet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.com.stanford.je0824.workingwithservlet.model.DataProvider;
import vn.com.stanford.je0824.workingwithservlet.model.Sach;

/**
 * Servlet implementation class GioHangServlet
 */
@WebServlet("/GioHangServlet")
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see  Xử lý lưu thông tin sách người dùng chọn vào giỏ hàng 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null)
		{
			int sachId = 0;
			
			sachId = Integer.parseInt("" + request.getParameter("id"));
			
			Sach objSach = DataProvider.getSachBus().layChiTietTheoMa(sachId);
			
			if(objSach != null)
			{
				boolean isHangDaCo = false;
				
				//Khai báo danh sách
				List<Sach> lstSach = new ArrayList<Sach>();
				
				HttpSession session = request.getSession(true);
				
				if(session != null && session.getAttribute("gioHang") != null)
				{
					lstSach = (List<Sach>)session.getAttribute("gioHang");
					
					//Duyệt xem có mặt hàng trong giỏ hay chưa
					for(int i = 0; i < lstSach.size(); i++)
					{
						if(lstSach.get(i).getId() == sachId)
						{
							objSach.setSoLuong(lstSach.get(i).getSoLuong() + 1);
							lstSach.set(i, objSach);
							isHangDaCo = true;
						}
					}
					
					if(isHangDaCo == false)
					{
						objSach.setSoLuong(1);
						//Thêm sách vào giỏ hàng
						lstSach.add(objSach);
					}
				}
				else
				{
					objSach.setSoLuong(1);
					//Thêm sách vào giỏ hàng
					lstSach.add(objSach);
				}
				
				//Lưu vào giỏ hàng
				session.setAttribute("gioHang", lstSach);
				
				response.sendRedirect("DanhSachSach.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

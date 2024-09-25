package vn.com.namcat.servletwork.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.com.namcat.servletwork.model.*;
/**
 * Servlet implementation class QuanLySach
 */
@WebServlet({"/sachadd"})
public class QuanLySach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setCharacterEncoding("UTF-8");
	    
		String tenSach = request.getParameter("txtTenSach");
		String moTa = request.getParameter("txtMoTa");
		String strGiaSach = request.getParameter("txtGiaSach");
		int giaSach = Integer.parseInt(strGiaSach);
		String tacGia = request.getParameter("txtTacGia");
		
		Sach objSach = new Sach();
		
		objSach.setTenSach(tenSach);
		objSach.setMoTa(moTa);
		objSach.setGiaSach(giaSach);
		objSach.setTacGia(tacGia);
		
		boolean ketQua;
		
		ketQua = DataProvider.getSachBus().themMoi(objSach);
		
		response.sendRedirect("QuanLySach.jsp");
	}

}

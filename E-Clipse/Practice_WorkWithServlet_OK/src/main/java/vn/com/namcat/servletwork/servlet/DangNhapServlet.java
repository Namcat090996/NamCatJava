package vn.com.namcat.servletwork.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set the display content
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//Display content in web page
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Làm việc với Servlet</title></head>"
				+ "<body>"
				+ "<div style='width:100%; text-align:center;'><h1>Đăng nhập hệ thống<h1></div>"
				+ "<form>"
				+ "<field>"
				+ "<legend>Nhập thông tin đăng nhập</legend>"
				+ "Tên đăng nhập: <input type='text' name='txtTenDangNhap'/><br>"
				+ "Mật khẩu: <input type='password' name='txtMatKhau'/><br>"
				+ "<input type='submit' name='btnDangNhap' value='Đăng nhập'/>"
				+ "<br>"
				+ "</field>"
				+ "</form>"
				+ "</body></html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khai báo biến
		String tenDangNhap = "", matKhau = "";		
		
		tenDangNhap = request.getParameter("txtTenDangNhap");
		matKhau = request.getParameter("txtMatKhau");
		
		System.out.println(tenDangNhap + matKhau);
	}

}

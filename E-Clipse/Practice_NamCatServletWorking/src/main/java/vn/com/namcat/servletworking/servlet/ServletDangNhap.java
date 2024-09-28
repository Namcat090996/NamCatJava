package vn.com.namcat.servletworking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDangNhap
 */
@WebServlet("/ServletDangNhap")
public class ServletDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Thiết lập nội dung hiển thị
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//Ghi nội dung ra trang web
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Làm việc với Servlet</title></head>"
				+ "<body>"
				+ "<div style='width:100%; text-align:center;'><h1>Đăng nhập hệ thống<h1></div>"
				+ "<form method='post'>"
				+ "<field>"
				+ "<legend>Nhập thông tin đăng nhập</legend>"
				+ "Tên đăng nhập: <input type='text' name='txtTenDangNhap'/><br>"
				+ "Mật khẩu: <input type='password' name='txtMatKhau'/><br>"
				+ "<input type='submit' name='btnDangNhap' value='Đăng nhập'/>"
				+ "<br>"
				+ "</field>"
				+ "</form>"
				+ "</body></html>");
		
		String diaChiIP = "", email = "", number = "";
		
		diaChiIP = getServletContext().getInitParameter("IP");
		email = getServletContext().getInitParameter("email");
		
		System.out.println(diaChiIP + email);
		
		number = getServletConfig().getInitParameter("number");
		
		System.out.println(number);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = "", matKhau = "";
		
		tenDangNhap = request.getParameter("txtTenDangNhap");
		matKhau = request.getParameter("txtMatKhau");
		
		System.out.println(tenDangNhap + matKhau);
	}

}

package vn.com.stanford.je0824.workingwithservlet.servlet;

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
				//Thiết lập nội dung hiển thị
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				
				//Hiển thị nội dung 1 trang web
				PrintWriter writer = response.getWriter();
				
				writer.println("<html><head><title>Làm việc với Servlet</title></head>"
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
				
				writer.close();
				
				//Lấy thông tin từ file cấu hình
				String diaChiIP = getServletContext().getInitParameter("IP");
				String email = getServletContext().getInitParameter("email");
				
				System.out.println("Địa chỉ IP: " + diaChiIP);
				System.out.println("Email: " + email);
				
				String diaChiServer = getServletConfig().getInitParameter("server");
				String tenDb = getServletConfig().getInitParameter("databasename");
				
				System.out.println("Địa chỉ Server: " + diaChiServer);
				System.out.println("Tên cơ sở dữ liệu: " + tenDb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Khai báo biến
		String tenDangNhap = "", matKhau = "";

		tenDangNhap = request.getParameter("txtTenDangNhap");
		matKhau = request.getParameter("txtMatKhau");

		System.out.println("Tên đăng nhập là: " + tenDangNhap);
		System.out.println("Mật khẩu: " + matKhau);
	}

}

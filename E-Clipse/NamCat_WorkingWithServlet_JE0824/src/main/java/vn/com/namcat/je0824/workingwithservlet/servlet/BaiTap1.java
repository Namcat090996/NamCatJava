package vn.com.namcat.je0824.workingwithservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaiTap1
 */
@WebServlet("/BaiTap1")
public class BaiTap1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaiTap1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập nội dung hiển thị
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		// Hiển thị nội dung trang web
		PrintWriter writer = response.getWriter();

		writer.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Đăng nhập hệ thống</title>\r\n"
				+ "    <!-- Declare a css library -->\r\n"
				+ "    <link rel=\"stylesheet\" href=\"css/baitap1.css\">\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <form method=\"post\">\r\n"
				+ "        <div style=\"width: 420px; margin: 30px auto;\" class=\"box1\">\r\n"
				+ "            <fieldset class=\"login_group_field\">\r\n"
				+ "                <legend class=\"anno\">Đăng nhập hệ thống</legend>\r\n"
				+ "                <img class=\"login_group_field--image\" src=\"../images/login_icon.png\">\r\n"
				+ "                <table style=\"border-collapse: collapse;\">\r\n"
				+ "                    <tr style=\"height: 30px;\">\r\n"
				+ "                        <td class=\"td1\">Tên đăng nhập:</td>\r\n"
				+ "                        <td>\r\n"
				+ "                            <input class=\"DangNhap__text\" type=\"text\" name=\"txtTaiKhoan\">\r\n"
				+ "                        </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr style=\"height: 30px;\">\r\n"
				+ "                        <td class=\"td1\">Mật khẩu:</td>\r\n"
				+ "                        <td>\r\n"
				+ "                            <input class=\"MatKhau__text\" type=\"password\" name=\"txtMatKhau\">\r\n"
				+ "                        </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <td></td>\r\n"
				+ "                        <td>\r\n"
				+ "                            <input class=\"DangNhap__image\" type=\"submit\" value=\"Đăng nhập\" name=\"btnDangNhap\">\r\n"
				+ "                            <input class=\"HuyBo__image\" type=\"submit\" value=\"Hủy bỏ\" name=\"btnHuyBo\">\r\n"
				+ "                        </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <td></td>\r\n"
				+ "                        <td>\r\n"
				+ "                            <span style=\"color: red\" id=\"error\"></span>\r\n"
				+ "                        </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                </table>\r\n"
				+ "            </fieldset>\r\n"
				+ "        </div>\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");

		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khai báo biến
		String tenDangNhap = request.getParameter("txtTaiKhoan");
		String matKhau = request.getParameter("txtMatKhau");
		
		System.out.println("Tên đăng nhập là: " + tenDangNhap + "\n" + "Mật khẩu là: " + matKhau);
	}

}

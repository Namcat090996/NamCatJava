package vn.com.namcat.servletwork.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DangKyNguoiDungServlet
 */
@WebServlet("/DangKyNguoiDungServlet")
public class DangKyNguoiDungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyNguoiDungServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//thiết lập nội dung hiển thị
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//hiển thị nội dung của 1 trang web
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>Thêm sủa xóa thông tin</title>"
				+ "<link rel='stylesheet' type='text/css' href='css/StyleStanford.css' />"
				+ "</head>"
				+ "<body>"
				+ "<form method='post'>"
				+ "<div style='width: 100%;'>"
				+ "<div style='width: 350px; margin-left: auto; margin-right: auto;' />"
				+ "<fieldset class='login_group_field'><legend>Nhập thông tin người dùng</legend>"
				+ "<table class='tdF'>"
				+ "<tr>"
				+ "<td>Tài khoản</td>"
				+ "<td><input type='text' name='txtTaiKhoan' /></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Mật khẩu</td>"
				+ "<td><input type='password' name='txtMatKhau' /></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Mật khẩu nhập lại</td>"
				+ "<td><input type='password' name='txtMatKhauNhapLai' /></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Giới tính</td>"
				+ "<td><input type='radio' name='gt' value='Nam'/>Nam &nbsp;"
				+ "<input type='radio' name='gt'  value='Nữ'/>Nữ</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Điện thoại</td>"
				+ "<td><input type='text' name='txtDienThoai'/></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Email</td>"
				+ "<td><input type='text' name='txtEmail' /></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Địa chỉ</td>"
				+ "<td><textarea rows='5' name='txtDiaChi'></textarea></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Trình độ học vấn</td>"
				+ "<td><select name= 'cboTrinhDo' >"
				+ "<option value='THPT'>THPT</option>"
				+ "<option value='TC'>Trung cấp</option>"
				+ "<option value='CD'>Cao đẳng</option>"
				+ "<option value='DH'>Đại học</option>"
				+ "<option value='ThS'>Thạc sĩ</option>"
				+ "<option value='TS'>Tiến sĩ</option>"
				+ "</select></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td></td>"
				+ "<td>"
				+ "<input type='submit' name='btnDangNhap' value='Cập nhật'/> &nbsp;"
				+ "<input type='submit' name='btnDangNhap' value='Hủy bỏ'/>"
				//+ "<a href='#' class='stanfButton'><img\r\n src='images/right_16.png' />Cập nhật</a>"
				//+ "<a href='#'\r\n class='stanfButton'/><img src=\"images/cancel.gif\" />Hủy bỏ</a></td>"
				+ "</tr>"
				+ "</table>"
				+ "</fieldset></div></div></form>"
				+ "</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

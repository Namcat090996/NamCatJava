package vn.com.stanford.je0824.workingwithservlet.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.com.stanford.je0824.workingwithservlet.model.*;

/**
 * Servlet implementation class SachServlet
 */
@WebServlet("/SachServlet")
public class SachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SachServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		// Khai báo biến
		boolean isInsert = true;
		String tenSach = "", moTa = "", anhSach = "", tacGia = "";
		int sachId = 0, giaSach = 0;

		if (request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty()) {
			sachId = Integer.parseInt("" + request.getParameter("hSachId"));
		}

		tenSach = request.getParameter("txtTenSach");
		moTa = request.getParameter("txtMoTa");
		anhSach = request.getParameter("txtAnhSach");
		tacGia = request.getParameter("txtTacGia");

		giaSach = Integer.parseInt("" + request.getParameter("txtGiaSach"));

		// Khai báo 1 đối tượng
		Sach objSach;
		objSach = new Sach();

		if (sachId > 0) {
			isInsert = false;
			objSach.setId(sachId);
		} else {
			Random rd = new Random();
			sachId = rd.nextInt(5, 100);
			objSach.setId(sachId);
		}

		// Gán giá trị cho các thuộc tính
		objSach.setTenSach(tenSach);
		objSach.setMoTa(moTa);
		objSach.setAnhSach(anhSach);
		objSach.setTacGia(tacGia);
		objSach.setGiaSach(giaSach);

		boolean ketQua = false;

		if (isInsert) {
			ketQua = DataProvider.getSachBus().themMoi(objSach);
		} else {
			ketQua = DataProvider.getSachBus().capNhat(objSach);
		}

		if (ketQua) {
			response.sendRedirect("QuanLySach.jsp");
		}

	}
}

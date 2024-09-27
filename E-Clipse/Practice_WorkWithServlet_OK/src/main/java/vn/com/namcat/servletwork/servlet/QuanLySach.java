package vn.com.namcat.servletwork.servlet;
import java.io.IOException;
import java.util.Random;

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//Declare variables
		String tenSach = "", anhSach = "", moTa = "", tacGia = "", strSachId = request.getParameter("hSachId");
		int giaSach = 0, sachId = 0;
		
		//Get sachId
		if(strSachId.length() > 0 && !strSachId.isEmpty())
		{
			sachId = Integer.parseInt(request.getParameter("hSachId"));			
		}
		
		//Get value from input
		tenSach = request.getParameter("txtTenSach");
		anhSach = request.getParameter("txtAnhSach");
		moTa = request.getParameter("txtMoTa");
		tacGia = request.getParameter("txtTacGia");
		giaSach = Integer.parseInt(request.getParameter("txtGiaSach"));
		
		//Declare object
		Sach objSach = new Sach();
		
		//Assign value to object
		objSach.setId(sachId);
		objSach.setTenSach(tenSach);
		objSach.setAnhSach(anhSach);
		objSach.setMoTa(moTa);
		objSach.setTacGia(tacGia);
		objSach.setGiaSach(giaSach);
				
		//Declare variable
		boolean ketQua = false;
		
		//Call the add or update function
		if(sachId > 0)
		{
			objSach.setId(sachId);
			ketQua = DataProvider.getSachBus().capNhat(objSach);			
		}
		else
		{
			Random rd = new Random();
			sachId = rd.nextInt(5, 100);
			objSach.setId(sachId);
			ketQua = DataProvider.getSachBus().themMoi(objSach);
		}
		
		//If successfully add or update 
		if(ketQua)
		{
			response.sendRedirect("QuanLySach.jsp");
		}
		
		
		
		
	}
}

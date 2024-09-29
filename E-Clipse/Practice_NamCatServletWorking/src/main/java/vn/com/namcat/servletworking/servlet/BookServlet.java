package vn.com.namcat.servletworking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.com.namcat.servletworking.model.*;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set the display content
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Process after clicking update
		//Declare variables
		boolean isInsert = true;
		String tenSach = "", anhSach = "", moTa = "", tacGia = "";
		int giaSach = 0, sachId = 0;
		
		//In case of update
		if(request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty())
		{
			sachId = Integer.parseInt(request.getParameter("hSachId"));			
		}
		
		//Get data from textfield
		tenSach = request.getParameter("txtTenSach");
		moTa = request.getParameter("txtMoTa");
		anhSach = request.getParameter("txtAnhSach");
		giaSach = Integer.parseInt(request.getParameter("txtGiaSach"));
		tacGia = request.getParameter("txtTacGia");
		
		//Catch the error
		if(tenSach.length() == 0)
		{
            out.println("<html><body>");
            out.println("<script type='text/javascript'>");
            out.println("alert('Username is required!');");  // JavaScript alert
            out.println("window.location.href = 'register.html';");  // Redirect back to registration page
            out.println("</script>");
            out.println("</body></html>");			
		}
		
		//Declare an object
		Sach objSach;
		
		//In case of updating a data book
		if(sachId > 0)
		{
			objSach = new Sach(sachId, tenSach, anhSach, moTa, tacGia, giaSach);
			isInsert = false;
		}
		else //In case of adding a new book
		{
			Random rd = new Random();
			sachId = rd.nextInt(5, 100);
			objSach = new Sach(sachId, tenSach, anhSach, moTa, tacGia, giaSach);
		}
		
		//Declare a boolean
		boolean ketQua = false;		
		
		//In case of adding a new book
		if(isInsert)
		{
			ketQua = DataSupplier.getSachBus().themMoiSach(objSach);
		}
		else //In case of updating a data book
		{
			ketQua = DataSupplier.getSachBus().capNhatSach(objSach);
		}
		
		//Go to page book manager
		if(ketQua)
		{
			response.sendRedirect("BookManager.jsp");	
		}
		
	}

}

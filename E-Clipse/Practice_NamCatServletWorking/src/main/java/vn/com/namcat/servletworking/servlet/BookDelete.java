package vn.com.namcat.servletworking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.com.namcat.servletworking.model.DataSupplier;

/**
 * Servlet implementation class BookDelete
 */
@WebServlet("/BookDelete")
public class BookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Check if the book id is null
		if(request.getParameter("id") != null)
		{
			//Declare varibles
			int sachId = 0;
			boolean isDel = false;
			
			try //Try-catch to catch the error if sachId cannot be convert to Integer
			{
				//Get book id
				sachId = Integer.parseInt(request.getParameter("id"));	
				
				//Delete the book
				isDel = DataSupplier.getSachBus().xoa(sachId);
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			if(isDel)
			{
				response.sendRedirect("BookManager.jsp");
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

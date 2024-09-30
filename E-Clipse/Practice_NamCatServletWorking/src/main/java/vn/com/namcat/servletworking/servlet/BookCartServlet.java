package vn.com.namcat.servletworking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import vn.com.namcat.servletworking.model.DataSupplier;
import vn.com.namcat.servletworking.model.Sach;

/**
 * Servlet implementation class BookCartServlet
 */
@WebServlet("/BookCartServlet")
public class BookCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Check if the id of book is null 
		if(request.getParameter("id") != null && !request.getParameter("id").isEmpty())
		{
			//Declare variables
			int sachId = 0;
		
			//Get the id of book
			sachId = Integer.parseInt(request.getParameter("id"));
			
			//Get the book object from id
			Sach objSach = DataSupplier.getSachBus().layChiTiet(sachId);
			
			//Check if the book object is null
			if(objSach != null)
			{
				//Declare a boolean
				boolean isHangDaCo = false;
				
				//Declare a session
				HttpSession session = request.getSession(true);		
				
				//Declare a book list in shopping cart
				List<Sach> lstSach = new ArrayList<Sach>();
				
				//Check if the session is null
				if(session != null && session.getAttribute("gioHang") != null)
				{
					//Get the book list from the session
					lstSach = (List<Sach>)session.getAttribute("gioHang");
					
					//Check if the book is already in the list
					for(int i = 0; i < lstSach.size(); i++)
					{
						//If the book is already in the list
						if(lstSach.get(i).getId() == sachId)
						{
							objSach.setSoLuong(lstSach.get(i).getSoLuong() + 1);
							lstSach.set(i, objSach);
							isHangDaCo = true;
						}
					}
					//If the book isn't already in the list
					if(isHangDaCo == false)
					{
						//Set the quantity of book object
						objSach.setSoLuong(1);
						
						//Add the book object to the list
						lstSach.add(objSach);
					}
				}
				//If the session i
				else
				{
					//Set the quantity of book object
					objSach.setSoLuong(1);
					
					//Add the book object to the list
					lstSach.add(objSach);					
				}
				
				//Save the list to the session
				session.setAttribute("gioHang", lstSach);
				
				//Refresh the book selection page
				response.sendRedirect("BookSelection.jsp");				
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

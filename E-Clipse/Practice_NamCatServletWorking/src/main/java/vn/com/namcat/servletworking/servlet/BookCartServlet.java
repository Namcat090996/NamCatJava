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
		
		//Check the if of book is null or not
		if(request.getParameter("id") != null)
		{
			//Get the id of book
			int sachId = Integer.parseInt(request.getParameter("id"));
			
			//Get the book from the id
			Sach objS = DataSupplier.getSachBus().layChiTiet(sachId);
			
			//If book object is not null
			if(objS != null)
			{
				//Declare a boolean
				boolean isHangDaCo = false;
				
				//Declare a session
				HttpSession session = request.getSession(true);
				
				//Declare a book list in shopping cart
				List<Sach> lstSach = new ArrayList<Sach>();
				
				if(session != null && session.getAttribute("cart") != null)
				{
					//Get the book list from the session 
					lstSach = (List<Sach>)session.getAttribute("cart");
					
					//Check if the book is in the shopping cart  
					for(int i = 0; i < lstSach.size(); i++)
					{
						if(lstSach.get(i).getId() == sachId)
						{
							objS.setSoLuong(lstSach.get(i).getSoLuong() + 1);
						}
					}
					
				}
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

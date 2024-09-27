package vn.com.namcat.servletwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.com.namcat.servletwork.model.DataProvider;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet({"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");		
		
		//Declare variable
		String sachId = "";
		int id = 0;
		
		//Convert to int
		if(request.getParameter("id") != null && !request.getParameter("id").isEmpty())
		{
			//Get value id to remove
			sachId = request.getParameter("id");
			
			//Convert it to int
			id = Integer.parseInt(sachId);	
			
			//Calculate and process
			boolean ketQua;
			
			ketQua = DataProvider.getSachBus().xoa(id);
			
			if(ketQua)
			{
				response.sendRedirect("QuanLySach.jsp");
			}
			else
			{
				response.getWriter().write("Xóa không thành công");
			}
		}
		else
		{
			response.getWriter().write("ID không hợp lệ");
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

package vn.com.namcat.servletwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
//@WebServlet("/hlsrl2")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String diaChiIP = getServletContext().getInitParameter("IP");	
		
		System.out.println("Địa chỉ IP là: " + diaChiIP);
		
		String diaChiServer = getServletConfig().getInitParameter("server");
		String tenDb = getServletConfig().getInitParameter("databasename");
		
		System.out.println("Địa chỉ Server: " + diaChiServer);
		System.out.println("Tên cơ sở dữ liệu: " + tenDb);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

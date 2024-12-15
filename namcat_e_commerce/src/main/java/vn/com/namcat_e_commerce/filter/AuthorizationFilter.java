package vn.com.namcat_e_commerce.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {
    /**
     * Default constructor.
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }
    
    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
		HttpServletRequest req = (HttpServletRequest) request;
        
        //Lấy session từ request
		HttpSession session = req.getSession();
		
		//Nếu session tồn tại (đăng nhập thành công)
		if (session != null && session.getAttribute("userOnline") != null)
        {
            // pass the request along the filter chain
            chain.doFilter(request, response);
		} else
        {
			HttpServletResponse res = (HttpServletResponse) response;
            
            //Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
			res.sendRedirect(req.getContextPath() + "/login");
		}
    }
    
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}

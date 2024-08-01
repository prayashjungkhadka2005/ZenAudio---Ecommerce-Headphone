 package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;

	    String uri = req.getRequestURI();
	    boolean isLoginPage = uri.endsWith("login.jsp") || uri.endsWith("LoginServlet");

	    HttpSession session = req.getSession(false);
	    boolean isLoggedIn = session != null && session.getAttribute("userName") != null;

	    // Check if session is inactive
	    if (session != null && !session.isNew() && session.getLastAccessedTime() + session.getMaxInactiveInterval() * 1000 < System.currentTimeMillis()) {
	        session.invalidate(); // Invalidate expired session
	        isLoggedIn = false; // Update login status
	    }

	    // Allow certain requests to bypass authentication
	    if (uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".png") || uri.endsWith(".jpeg") || uri.endsWith("register.jsp") || uri.endsWith("RegisterServlet") || !uri.endsWith("AddProductsServlet")|| uri.endsWith("pages/products.jsp") || uri.endsWith("pages/userhome.jsp") ) {
	        chain.doFilter(request, response);
	        return;
	    }

	    // Redirect to login page if not logged in and not accessing login-related pages or AddToCart
	    if (!isLoggedIn && !isLoginPage && !uri.endsWith("AddToCart") && !uri.endsWith("shoppingcart.jsp") && !uri.endsWith("adminpanel.jsp") &&  !uri.endsWith("AddProductsServlet")  ){
	        res.sendRedirect(req.getContextPath() + "/pages/login.jsp");
	        return;
	    }

	    // Continue the filter chain
	    chain.doFilter(request, response);
	}



}
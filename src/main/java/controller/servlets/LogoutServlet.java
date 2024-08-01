 package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Cookie[] cookies = request.getCookies();
		    if(cookies != null) {
		        for (Cookie cookie: cookies) {
		            cookie.setMaxAge(0);
		            response.addCookie(cookie);
		        }
		    }

		    // Invalidate session
		    HttpSession session = request.getSession(false);
		    if (session != null) {
		        session.invalidate();
		    }

		    // Set JSESSIONID cookie to empty
		    Cookie jsessionCookie = new Cookie("JSESSIONID", "");
		    jsessionCookie.setMaxAge(0);
		    response.addCookie(jsessionCookie);

		    // Redirect to login page
		    response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
	}

}

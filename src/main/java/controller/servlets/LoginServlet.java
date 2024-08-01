package controller.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;
import controller.DatabaseController;
import model.ZenAudioModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DatabaseController dbController = new DatabaseController();
	
    public LoginServlet() {
        super();
    }

	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName= request.getParameter(StringUtils.USER_NAME);
        String password = request.getParameter(StringUtils.PASSWORD);
        
        // Check login credentials
        int loginResult = dbController.getUserLoginInfo(userName, password);
        
        if (loginResult == 1) {

            HttpSession userSession = request.getSession();
            // Set the attribute with name "username"
            userSession.setAttribute("username", userName);

            userSession.setMaxInactiveInterval(60); // 1 minute in seconds

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute in seconds
            response.addCookie(userCookie);
            // Debug message
            System.out.println("User logged in successfully. userName: " + userName);

            String userRole = null;
            try {
                userRole = dbController.getUserRole(userName);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (userRole.equals("admin")) {
                request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
                request.getRequestDispatcher(StringUtils.ADMIN_PANEL).forward(request, response);
            } else if (userRole.equals("customer")){
                request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
                request.getRequestDispatcher(StringUtils.HOME_PAGE).forward(request, response);
            } else {
                request.setAttribute(StringUtils.ERROR_MESSAGE, "User details not found");
                request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
            }
            
        } else if (loginResult == 0) {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_LOGIN_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        } else {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
    }


}

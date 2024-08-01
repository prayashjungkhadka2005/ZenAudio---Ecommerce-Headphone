package controller.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.ZenAudioModel;
import util.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DatabaseController dbController = new DatabaseController();

	public RegisterServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    // Extract parameters from request
	    String userName = request.getParameter(StringUtils.USER_NAME);
	    String email = request.getParameter(StringUtils.EMAIL);
	    String password = request.getParameter(StringUtils.PASSWORD);
	    String role = request.getParameter(StringUtils.ROLE);
	    String retypePassword = request.getParameter(StringUtils.CONFIRM_PASSWORD);
	    LocalDateTime registeredAt = LocalDateTime.now();

	    // First, check if the passwords match
	    if (!password.equals(retypePassword)) {
	        // If passwords do not match, forward to the registration page with an error message
	        request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
	        request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	        return; // Important to return to stop further execution
	    }

	    // Create a new user model object
	    ZenAudioModel zenAudioModel = new ZenAudioModel(userName, email, password, role, registeredAt);

	    // Since passwords match, proceed to add user to database
	    int result = dbController.addUser(zenAudioModel);

	    // Handle the result of the database operation
	    switch (result) {
	        case 1 -> {
	            request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
	            response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
	            
	        }
	        case 0 -> {
	            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
	            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	        }
	        case -1 -> {
	            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
	            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	        }
	        case -2 -> {
	            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_ERROR_MESSAGE);
	            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	        }
	        case -3 -> {
	            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_ERROR_MESSAGE);
	            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	        }
	        default -> {
	            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
	            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	            
	        }
	    }
	}


	}

	package controller.servlets;
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import controller.DatabaseController;
	import util.StringUtils;
	
	/**
	 * Servlet implementation class ModifyServlet
	 */
	@WebServlet("/ModifyServlet")
	public class ModifyServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		DatabaseController dbController = new DatabaseController();
	    
	    public ModifyServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		
	    
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String deleteId = request.getParameter("deleteId");
			
		
			
			
			
			
			
			if (deleteId != null && !deleteId.isEmpty()) {
				doDelete(request, response);
			}
		}
		
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Delete Trigerred");
			int deleteId = Integer.parseInt(request.getParameter("deleteId"));
			
			
			int deletionResult = dbController.deleteCartInfo(deleteId);
			if (deletionResult == 1) {
				request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_DELETE_MESSAGE);
				response.sendRedirect(request.getContextPath() + StringUtils.HOME_PAGE);
		    } else {
		    	request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_CART_DELETE);
				response.sendRedirect(request.getContextPath() + StringUtils.SHOPPING_CART);
		    }
//			if(dbController.deleteCartInfo(deleteId) == 1 ) {
				
//			}
//			else {
				
//				System.out.print("not");
//			}
		}
	
	}

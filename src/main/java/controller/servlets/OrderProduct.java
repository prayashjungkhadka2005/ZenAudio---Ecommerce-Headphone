//package controller.servlets;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import controller.DatabaseController;
//import model.CartModel;
//import util.StringUtils;
//
///**
// * Servlet implementation class OrderProduct
// */
//@WebServlet("/OrderProduct")
//public class OrderProduct extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public OrderProduct() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
////
//	
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 throws ServletException, IOException {
//		        String productName = request.getParameter(StringUtils.CART_PRODUCT_NAME);
//
//		        DatabaseController dbController = new DatabaseController();
//
//		        // Retrieve user ID from the session
//		        HttpSession session = request.getSession();
//		        String userName = (String) session.getAttribute("username");
//		        System.out.println("Username retrieved from session: " + userName);
//
//		        if (userName != null) {
//		            int userId = dbController.getUserIdByName(userName);
//
//		            // Access the product ID from the database based on the product name
//		            int productId = dbController.getProductIdByName(productName);
//
//		            // Get the current date
//		            LocalDateTime addedAt = LocalDateTime.now();
//
//		            CartModel cart = new CartModel(addedAt, userId, productId);
//
//		            int result = dbController.addToCart(cart);
//
//		            switch (result) {
//		                case 1:
//		                    request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_ADDED_CART);
//		                    System.out.print("added success");
//		                    request.getRequestDispatcher(StringUtils.HOME_PAGE).forward(request, response);
//		                    break;
//		                case 0:
//		                default:
//		                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
//		                    System.out.print("server erro");
//		                    request.getRequestDispatcher("pages/products.jsp").forward(request, response);
//		                    break;
//		            }
//		        } else {
//		            // Handle case where userName is null
//		            request.setAttribute(StringUtils.ERROR_MESSAGE, "User not logged in");
//		            System.out.print("error");
//		            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
//		        }
//
//		       
//		    }
//
//	}
//
//}

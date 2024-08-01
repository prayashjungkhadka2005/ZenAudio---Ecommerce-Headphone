package controller.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controller.DatabaseController;
import model.ProductModel;
import util.StringUtils;

/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductsServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB)
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DatabaseController dbController = new DatabaseController();
	
    public AddProductsServlet() {
        super();
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Fetch all student details from the database
//        List<ProductModel> products = dbController.getAllProducts();
//
//        // Set the list of students as an attribute in the request object
//        request.setAttribute("products", products);
//
//        // Forward the request to the students.jsp page
//        request.getRequestDispatcher("pages/userhome.jsp").forward(request, response);
//    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
	        String userName = (String) session.getAttribute("username");
	        System.out.println("Username retrieved from session: " + userName);
		
		String productName = request.getParameter(StringUtils.PRODUCT_NAME);
		String productDescription = request.getParameter(StringUtils.PRODUCT_DESCRIPTION);
		int productStock = Integer.parseInt(request.getParameter(StringUtils.PRODUCT_STOCK));
		int productPrice = Integer.parseInt(request.getParameter(StringUtils.PRODUCT_PRICE));
		int discountedPrice = Integer.parseInt(request.getParameter(StringUtils.PRODUCT_DISCOUNTED_PRICE));
		Part imagePart = request.getPart(StringUtils.PRODUCT_IMAGE);
		LocalDateTime updatedAt = LocalDateTime.now();
		
		ProductModel productDetails = new ProductModel(imagePart, productName, productDescription, productStock, productPrice, discountedPrice, updatedAt);
		
		String savePath = StringUtils.IMAGE_DIR;
		String fileName = productDetails.getImageUrlFromPart();
		
		
		
		if (!fileName.isEmpty() && fileName != null) {
			imagePart.write(savePath + fileName);
		}
		
		int result = dbController.addProducts(productDetails);
		
		switch(result) {
			case 1 -> {
				request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_PRODUCT_UPLOAD);
				response.sendRedirect(request.getContextPath() + StringUtils.ADMIN_PANEL);
				
			}
			
			case 0 ->{
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.ADD_PRODUCTS_PAGE).forward(request, response);
			}
			
			case -1 ->{
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_PRODUCT_UPLOAD);
				request.getRequestDispatcher(StringUtils.ADD_PRODUCTS_PAGE).forward(request, response);
			}
			
			default -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.ADD_PRODUCTS_PAGE).forward(request, response);
			}
			
		
		}
	}

}

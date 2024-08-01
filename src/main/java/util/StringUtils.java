package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StringUtils
 */
@WebServlet("/StringUtils")
public class StringUtils extends HttpServlet {
	public static final String INSERT_USER = "INSERT INTO user "
            + "(user_name, email, password, role, registered_at) "
            + "VALUES (?, ?, ?, ?, ?)";
	
	public static final String INSERT_PRODUCT_DETAILS = "INSERT INTO product"
			+ "(product_name, product_desc, stock, image, price, discounted_price, last_updated)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String INSERT_CART_DETAILS = "INSERT INTO cart"
			+ "(added_date,user_id, product_id) "
			+ "VALUES (?, ?, ?)";
	
	public static final String DELETE_CART_INFO_BY_ID = "DELETE FROM cart WHERE cart_id = ?";

	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM user WHERE user_name = ?";
	public static final String GET_USER_ROLE = "SELECT role FROM user WHERE user_name = ?";
	public static final String GET_USERNAME = "SELECT COUNT(*) FROM user WHERE user_name = ?";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM user WHERE email = ?";
	public static final String GET_PRODUCT_NAME = "SELECT COUNT(*) FROM products WHERE product_name = ?";
	public static final String GET_ALL_PRODUCTS =  "SELECT product_name, price, image FROM product";
	public static final String GET_PRODUCT_ID = "SELECT product_id FROM product WHERE product_name = ?";
	public static final String GET_USER_ID = "SELECT user_id FROM user WHERE user_name = ?";
	
	public static final String GET_CART_BY_USER_ID= "SELECT * FROM cart WHERE user_id=?";
	public static final String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE product_id=?";
	
	public static final String GET_ADMIN_PRODUCTS =  "SELECT * FROM product";

	
    public static final String USER_NAME = "userName";
    public static final String EMAIL = "email";
    public static final String ROLE = "role";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmPassword";
    
    public static final String CART_PRODUCT_NAME = "productName";
    
    
     public static final String IMAGE_DIR = "C:/Users/User/eclipse-workspace/ZenAudioProjects/src/main/webapp/resources/images";
    
    public static final String PRODUCT_NAME = "productName";
    public static final String PRODUCT_DESCRIPTION = "productDescription";
    public static final String PRODUCT_STOCK = "productStock";
    public static final String PRODUCT_PRICE = "productPrice";
    public static final String PRODUCT_DISCOUNTED_PRICE = "discountedPrice";
    public static final String PRODUCT_IMAGE = "image";

    // Start Message
    public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered";
    public static final String REGISTER_ERROR_MESSAGE = "Please correct the form data";
    public static  final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
    public static final String SUCCESS_MESSAGE = "successMessage";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String USERNAME_ERROR_MESSAGE = "Username is already registered.";
    public static final String EMAIL_ERROR_MESSAGE = "Email is already registered.";
    public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password does not match.";
    public static final String SUCCESS_ADDED_CART = "Product successfully added to cart";
    public static final String ERROR_CART_DELETE= "ERROR CART DELETE";
    public static final String SUCCESS_DELETE_MESSAGE = "CART DELETE SUCCESS";
    // End Messages
    
    public static final String SUCCESS_PRODUCT_UPLOAD = "Product added successfully.";
    public static final String ERROR_PRODUCT_UPLOAD = "Product name already exits.";
    
 // Start login page message
 	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully LoggedIn!";
 	public static final String ERROR_LOGIN_MESSAGE = "Either username or password is not correct!";
 	// End login page message

    // Start Servlet Route
    public static final String REGISTER_SERVLET = "/RegisterServlet";
    public static final String DISPLAY_SERVLET = "/ProductDisplayServlet";
    // End Servlet Route
 
    public static final String REGISTER_PAGE = "/pages/register.jsp";
    public static final String LOGIN_PAGE = "/pages/login.jsp";
    public static final String HOME_PAGE = "/pages/userhome.jsp";
    public static final String ADMIN_PANEL = "/pages/adminpanel.jsp";
    public static final String ADD_PRODUCTS_PAGE = "/pages/addproducts.jsp";
    public static final String SHOPPING_CART = "/pages/shoppingcart.jsp";
}

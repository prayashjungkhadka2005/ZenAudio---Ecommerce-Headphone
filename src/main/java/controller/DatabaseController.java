package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartModel;
import model.PasswordEncryptionWIthAes;
import model.ProductModel;
import model.ZenAudioModel;
import util.StringUtils;
import javax.servlet.http.Part;

import com.mysql.cj.jdbc.admin.MiniAdmin;


/**
 * Servlet implementation class DatabaseController
 */
@WebServlet("/DatabaseController")
public class DatabaseController extends HttpServlet {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/zenaudio";
        String user = "root";
        String pass = "";
        
        return DriverManager.getConnection(url, user, pass);
    }
    

	public int addUser(ZenAudioModel zenAudioModel) {
	    try (Connection con = getConnection()) {
	    	
	        PreparedStatement st = con.prepareStatement(StringUtils.INSERT_USER);
	        
	        PreparedStatement checkUsernameSt = con.prepareStatement(StringUtils.GET_USERNAME);
            checkUsernameSt.setString(1, zenAudioModel.getUserName());
            ResultSet checkUsernameRs = checkUsernameSt.executeQuery();

            checkUsernameRs.next();

            if (checkUsernameRs.getInt(1) > 0) {
                return -2; // Username already exists
            }
            
            PreparedStatement checkEmailSt = con.prepareStatement(StringUtils.GET_EMAIL);
            checkEmailSt.setString(1, zenAudioModel.getEmail());
            ResultSet checkEmailRs = checkEmailSt.executeQuery();

            checkEmailRs.next();

            if (checkEmailRs.getInt(1) > 0) {
                return -3; // Email already exists
            }

	        
	        // Encrypt password before storing it in the database
            String encryptedPassword = PasswordEncryptionWIthAes.encryptPassword(zenAudioModel.getPassword(), "U3CdwubLD5yQbUOG92ZnHw==");
            
	        st.setString(1, zenAudioModel.getUserName());
	        st.setString(2, zenAudioModel.getEmail());
	        st.setString(3, encryptedPassword);
	        st.setString(4, zenAudioModel.getRole());
	        st.setTimestamp(5, Timestamp.valueOf(zenAudioModel.getRegisteretAt()));

	        int result = st.executeUpdate();
	        return result > 0 ? 1 : 0;
	    } catch (SQLException | ClassNotFoundException ex) {
	    	ex.printStackTrace(); // Log the exception for debugging
            return -1;
	    } catch (Exception e) {
	    	e.printStackTrace();
            return -1;
	    }
	}
	
	public int getUserLoginInfo(String username, String password) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_USER_INFO);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String userDb = rs.getString("user_name");
                String encryptedPassword = rs.getString("password");

                // Decrypt password from database and compare
                String decryptedPassword = PasswordEncryptionWIthAes.decryptPassword(encryptedPassword, "U3CdwubLD5yQbUOG92ZnHw==");

                if (decryptedPassword!=null && userDb.equals(username) && decryptedPassword.equals(password)) {
                    return 1; // Login successful
                } else {
                    return 0; // Password mismatch
                }
            } else {
                // No matching record found
                return 0;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
	

		public String getUserRole(String userName) throws SQLException, ClassNotFoundException {
		    try (Connection connection = getConnection();
		         PreparedStatement statement = connection.prepareStatement(StringUtils.GET_USER_ROLE)) { // Ensure the SQL for fetching the role is correct
		        statement.setString(1, userName);
		        try (ResultSet resultSet = statement.executeQuery()) {
		            if (resultSet.next()) {
		                return resultSet.getString("role"); // Assuming 'role' is the column name in your database
		            } else {
		                // No user found with the given username
		                return null;
		            }
		        }
		    } catch (SQLException | ClassNotFoundException ex) {
		        ex.printStackTrace(); // Log the exception
		        throw ex; // Rethrow the exception to handle it or log it upstream.
		    }
		}
		
		public int addToCart(CartModel cartModel) {
		    try (Connection con = getConnection()) {
		        PreparedStatement st = con.prepareStatement(StringUtils.INSERT_CART_DETAILS);
		        st.setTimestamp(1, Timestamp.valueOf(cartModel.getAddedAt()));
		        st.setInt(2, cartModel.getUserId());
		        st.setInt(3, cartModel.getProductId());

		        int result = st.executeUpdate();
		        return result > 0 ? 1 : 0;
		    } catch (SQLException e) {
		        // Handle any SQL exceptions
		        e.printStackTrace(); // Example: print the stack trace
		        return 0; // Return 0 to indicate failure
		    } catch (ClassNotFoundException e) {
		        // Handle the class not found exception
		        e.printStackTrace(); // Example: print the stack trace
		        return 0; // Return 0 to indicate failure
		    }
		}

		public int addProducts(ProductModel productModel) {
			try (Connection con = getConnection()) {
		    	
		        PreparedStatement st = con.prepareStatement(StringUtils.INSERT_PRODUCT_DETAILS);
		        
		        PreparedStatement checkProductnameSt = con.prepareStatement(StringUtils.GET_USERNAME);
	            checkProductnameSt.setString(1, productModel.getpName());
	            ResultSet checkProductnameRs = checkProductnameSt.executeQuery();

	            checkProductnameRs.next();

	            if (checkProductnameRs.getInt(1) > 0) {
	                return -1; // Product Name already exists
	            }

		        st.setString(1, productModel.getpName());
		        st.setString(2, productModel.getpDescription());
		        st.setString(4, productModel.getImageUrlFromPart());
		        st.setInt(3, productModel.getpStock());
		        st.setInt(5, productModel.getpPrice());
		        st.setInt(6, productModel.getpDicountedPrice());
		        st.setTimestamp(7, Timestamp.valueOf(productModel.getLastUpdated()));

		        int result = st.executeUpdate();
		        return result > 0 ? 1 : 0;
		    } catch (SQLException | ClassNotFoundException ex) {
		    	ex.printStackTrace(); // Log the exception for debugging
	            return -1;
		    } catch (Exception e) {
		    	e.printStackTrace();
	            return -1;
		    }
		}
		
			public List<ProductModel> getAllProducts() {
			    List<ProductModel> products = new ArrayList<>();
			    try (Connection con = getConnection()) {
			        PreparedStatement st = con.prepareStatement(StringUtils.GET_ALL_PRODUCTS);
			        ResultSet rs = st.executeQuery();
			        while (rs.next()) {
			            String product_name = rs.getString("product_name"); // Use column name
			            int product_price = rs.getInt("price"); // Use column name
			            String image = rs.getString("image");
			           
			            
			            ProductModel obj = new ProductModel(product_name, product_price, image);
			            // Add other product details as needed
			            products.add(obj);
			        }
			    } catch (SQLException | ClassNotFoundException ex) {
			        ex.printStackTrace(); // Log the exception for debugging
			    }
			    
			    return products;
			}
			
			public List<ProductModel> getAdminProductDetails() {
			    List<ProductModel> adminProducts = new ArrayList<>();
			    try (Connection con = getConnection()) {
			        PreparedStatement st = con.prepareStatement(StringUtils.GET_ADMIN_PRODUCTS);
			        ResultSet rs = st.executeQuery();
			        while (rs.next()) {
			            String product_name = rs.getString("product_name"); // Use column name
			            int product_price = rs.getInt("price"); // Use column name
			            String image = rs.getString("image");
			            String product_description = rs.getString("product_desc");
			            int product_id = rs.getInt("product_id");
			            int product_dis = rs.getInt("discounted_price");
			            LocalDateTime updated_at = rs.getTimestamp("last_updated").toLocalDateTime();
			            int stock = rs.getInt("stock");
			           
			            
			            ProductModel obj = new ProductModel(product_id, image, product_name, product_description, stock, product_price, product_dis, updated_at);
			            // Add other product details as needed
			            adminProducts.add(obj);
			        }
			    } catch (SQLException | ClassNotFoundException ex) {
			        ex.printStackTrace(); // Log the exception for debugging
			    }
			    
			    return adminProducts;
			}
			
			public List<CartModel> getCartDetails(int userId) {
			    List<CartModel> cart = new ArrayList<>();
			    try (Connection con = getConnection()) {
			        PreparedStatement st = con.prepareStatement(StringUtils.GET_CART_BY_USER_ID);
			        st.setInt(1, userId); // Bind the user ID parameter
			        ResultSet rs = st.executeQuery();

			        while (rs.next()) {
			            int cartId = rs.getInt("cart_id");
			            LocalDateTime addedAt = rs.getTimestamp("added_date").toLocalDateTime();
			            int productId = rs.getInt("product_id");

			            // Retrieve product details based on product ID
			            PreparedStatement productSt = con.prepareStatement(StringUtils.GET_PRODUCT_BY_ID);
			            productSt.setInt(1, productId);

			            ResultSet productRs = productSt.executeQuery();
			            if (productRs.next()) {
			                String productName = productRs.getString("product_name");
			                String description = productRs.getString("product_desc");
			               
			                int price = productRs.getInt("price");
			                int totalStock = productRs.getInt("stock");
			                String image = productRs.getString("image"); // Assuming image is stored as string

			                // Assuming you have a constructor in CartModel that accepts these parameters
			                CartModel cartItem = new CartModel(cartId,addedAt, productName, description, totalStock, price, image);
			                	
			                cart.add(cartItem);
			            }
			        }
			    } catch (SQLException | ClassNotFoundException ex) {
			        ex.printStackTrace(); // Log the exception for debugging
			    }
			    return cart;
			}


			public int getProductIdByName(String productName) {
			    try (Connection connection = getConnection()) {
			        PreparedStatement statement = connection.prepareStatement(StringUtils.GET_PRODUCT_ID);
			        
			        statement.setString(1, productName);

			        ResultSet resultSet = statement.executeQuery();
			        
			        if (resultSet.next()) {
			            return resultSet.getInt(1);
			        } else {
			            // No matching product found
			            return -1;
			        }
			    } catch (ClassNotFoundException | SQLException e) {
			        // Handle the exception (e.g., log it or throw a custom exception)
			        e.printStackTrace(); // Example: print the stack trace
			        return -1; // Return a default value or handle the error in another way
			    }
			}
			public int getUserIdByName(String userName) {
			    try (Connection connection = getConnection();
			         PreparedStatement statement = connection.prepareStatement(StringUtils.GET_USER_ID)) {
			        
			        statement.setString(1, userName);
			        try (ResultSet resultSet = statement.executeQuery()) {
			            if (resultSet.next()) {
			                return resultSet.getInt(1);
			            } else {
			                // No matching user found
			                return -1;
			            }
			        }
			    } catch (ClassNotFoundException | SQLException e) {
			        // Handle the exception (e.g., log it or throw a custom exception)
			        e.printStackTrace(); // Example: print the stack trace
			        return -1; // Return a default value or handle the error in another way
			    }
			}




			 public int deleteCartInfo(int cartId) {
			        try (Connection con = getConnection()) {
			            PreparedStatement st = con.prepareStatement(StringUtils.DELETE_CART_INFO_BY_ID);
			            st.setInt(1, cartId);

			            int result = st.executeUpdate();
			            return result > 0 ? 1 : 0; // Return 1 if deletion is successful, otherwise return 0
			        } catch (SQLException | ClassNotFoundException ex) {
			            ex.printStackTrace(); // Log the exception for debugging
			            return -1; // Return -1 for any exceptions
			        }
			    }
			    



	
	

}

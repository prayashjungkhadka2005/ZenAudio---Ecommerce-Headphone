<%@page import="model.CartModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource var="dbConnection" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/zenaudio" user="root" password="" />

<%

HttpSession usession = request.getSession();
String userName = (String) usession.getAttribute("username");
System.out.println("Current Session Username in Shopping Cart: " + userName);
    

    
        DatabaseController dbController = new DatabaseController();
        int userId = dbController.getUserIdByName(userName);
        List<CartModel> cartitems = dbController.getCartDetails(userId);

       %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/eed0f9355e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/shoppingcart.css">
    <title>Shopping cart</title>
</head>
<body>
    <div class="container">
        <div class="fdiv">
            <h2 class="slogan">"Discover Your Signature Sound! Claim 15% off Your Next Earbud Upgrade!"</h2>
            <div class="navbar">
                <div>
                    <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="">
                </div>
                <div class="cover_div">
                    <nav>
                        <ul>
                           <a href="${pageContext.request.contextPath}/pages/userhome.jsp"><li>Home</li></a>
               <a href="${pageContext.request.contextPath}/pages/products.jsp"> </a> <li>Products</li>
                <li>About us</li>
                        </ul>
                    </nav>
                    <div class="search_div">
                        <div class="search">
                            <input type="text" placeholder="search 'ZenAudio'">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </div>
                        <div>
                             <a href="${pageContext.request.contextPath}/pages/login.jsp">"></a> <i class="fa-regular fa-user user"></i>
                <a href="${pageContext.request.contextPath}/pages/shoppingcart.jsp"><i class="fa-solid fa-cart-shopping"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="shopping">
            <div class="s">
                <i class="fa-solid fa-chevron-left"></i> <a href="Product.html"> <h1>Shopping continue</h1></a>
            </div>
            <div>
               <button>Order History</button>
            </div>
        </div>
        
       <!-- shopping cart-->
        <div class="shopping-cart">
     
            <div class="cart-header">
              <hr class="hrr">
              <h1>Shopping cart</h1>
              <small class="item-count">You have 3items in your cart</small>
              <div>
              
                <!-- product cart -->
           
         <% for (CartModel cart : cartitems) { %>
            <div class="prod">
        
            <p class="date"><%= cart.getAddedAt() %></p>
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images<%= cart.getImageUrlFromPart() %>" alt="" class="product-image" />
                <div class="product-details">
                    <div>
                        <h1 class="product-name"><%= cart.getProductName() %></h1>
                        <small class="price"><%= cart.getProductDescription() %></small>
                    </div>
                    <div class="quantity">
                        <label for="">quantity:</label>
                        <button class="decrease-btn">-</button>
                        <input type="number" class="quantity-input" value="1" min="1" max="10" />
                        <button class="increase-btn">+</button>
                    </div>
                    <h2>NPR <%= cart.getProductPrice() %></h2>
                    <form id="deleteForm-<%=cart.getProductName() %>" method="post" action="${pageContext.request.contextPath}/ModifyServlet">
                   
                                    <input type="hidden" name="deleteId" value="<%=cart.getCardId() %>" />
                                    <button class="btn btn-danger btn-sm delete-btn" role="button" onclick="return confirmDelete('<%= cart.getProductName()%>')">
                                        <i class="fa-solid fa-trash"></i>
                                    </button>
                                </form>
                    
                   <button >   </button>
                </div>
            </div>
             
         
        
        </div>
   <% } %>   
              </div>

            </div>
            <div class="payment">
                <h1>Card Details</h1>
                <h4>Select Payment type</h4>
               <div class="card">
    <input type="radio" id="esewa" name="paymentMethod" value="esewa">
    <label for="esewa">
        <img src="${pageContext.request.contextPath}/resources/images/esewa.webp" alt="" class="esewa">
    </label>
    <input type="radio" id="khalti" name="paymentMethod" value="khalti">
    <label for="khalti">
        <img src="${pageContext.request.contextPath}/resources/images/khalti.jpeg" alt="">
    </label>
</div>
               
                <hr class="hr">

                <div class="amount">
                  <h2>Shipping</h2>
                  <h2>Rs. 180</h2>
                </div>
                <div class="amount">
                  <h2>Total(tax incl.)</h2>
                  <h2>Rs. 1900</h2>
                </div>
                
                <div class="total">
                  <h2>subtotal</h2>
                  <h2>Rs. 2080</h2>
                </div>
                <div class = "check" style="padding-left: 130px; padding-top: 20px;">
                <form action="${pageContext.request.contextPath}/OrderProduct">
                	 <button style="color: black;">Checkout</button>
                </form>
               
                
                </div>
            </div>
          </div>
          
     <script>
     function confirmDelete(productName) {
 		if(confirm("Are you sure you want to delete this product: " + productName + "?")){
 			document.getElementById("deleteForm-" + productName).submit();
 		}
 	}

     </script>
     
    <script src="${pageContext.request.contextPath}/stylesheet/index.js"></script>
</body>
</html>

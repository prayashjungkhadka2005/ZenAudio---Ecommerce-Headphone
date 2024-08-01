<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.DatabaseController" %>
<%@page import="util.StringUtils"%> 
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource var="dbConnection" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/zenaudio" user="root" password="" />

<%
    HttpSession userSession = request.getSession();
    String userName = (String) userSession.getAttribute("username");
    System.out.println("Current Session Username in UserHome: " + userName);
    DatabaseController dbController = new DatabaseController();
    
    List<ProductModel> products =  dbController.getAllProducts();
    
   

%>


<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/eed0f9355e.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/userhome.css" />
    <title>Home</title>
  </head>
  <body>
  
    <div class="container">
      <!-- fix div -->
      <div class="fdiv">
        <!-- navbar -->
        <div class="navbar">
          <div>
            <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" />
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
                <input type="text" placeholder="search 'ZenAudio'" />
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
      <!-- fix div end -->
      <div class="homeImg">
        <img src="${pageContext.request.contextPath}/resources/images/homeImg.png" alt="" />
      </div>

      <!-- Brand -->

      <h1 class="title">Shop Brand-Wise</h1>
      <div class="b">
        <div class="brand">
          <div>
            <img src="${pageContext.request.contextPath}/resources/images/boat.jpeg" alt="" />
          </div>

          <div>
            <img src="${pageContext.request.contextPath}/resources/images/hammer.jpeg" alt="" />
          </div>
          <div>
            <img src="${pageContext.request.contextPath}/resources/images/sennheiser.jpeg" alt="" />
          </div>
          <div>
            <img src="${pageContext.request.contextPath}/resources/images/sony.jpeg" alt="" />
          </div>
          <div>
            <img
              src="${pageContext.request.contextPath}/resources/images/apple.jpeg"
              alt=""
              style="width: 70px; height: auto"
            />
          </div>
        </div>
      </div>
      <% 
        String successMessage = (String) request.getAttribute(StringUtils.SUCCESS_MESSAGE);
        String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);

        if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
        <!-- Display error message -->	
         <div class="alert alert-danger mt-2" role="alert">
            <%= errorMessage %>
        </div>
        <% } %>

        <% 
        if (successMessage != null && !successMessage.isEmpty()) {
        %>
        <!-- Display success message -->
        <div class="alert alert-success mt-2" role="alert">
            <%= successMessage %>
        </div>
        <% } %>
      <!-- New Launches -->
      <h1 class="title">New Launches</h1>
      <div class="new_launches">
        <div class="gridItem col-2">
          <div class="grid_item">
            <img src="${pageContext.request.contextPath}/resources/images/img2.jpeg" alt="" class="" />
          </div>
          <div class="img-div">
            <div class="aa">
              <img src="${pageContext.request.contextPath}/resources/images/img1.jpeg" alt="" class="img1" />
              <img src="${pageContext.request.contextPath}/resources/images/img1.jpeg" alt="" class="img2" />
            </div>

            <div><img src="${pageContext.request.contextPath}/resources/images/img4.jpeg" alt="" class="" /></div>
            <div><img src="${pageContext.request.contextPath}/resources/images/img6.png" alt="" class="" /></div>
          </div>
        </div>
      </div>

      <!-- Explore Bestseller -->
      <div class="ex">
        <div class="aa">
          <h1 class="h">New Launches</h1>
          <div class="viewmore">
            <h2 class="hh"><a href="${pageContext.request.contextPath}/pages/products.jsp">view all</a></h2>
            <div>
              <i class="fa-solid fa-arrow-right"></i>
            </div>
          </div>
        </div>
        
        
        
      <div class="explore" >
    <!-- Display each product in a cart -->
    <%-- Iterate over each product in the list --%>
       <% for (ProductModel product : products) { %>
    <div class="cart">
        <div class="a">
            <img src="${pageContext.request.contextPath}/resources/images<%= product.getImageUrlFromPart() %>" alt="" />
            <div class="c">
                <div>
                    <h2><%= product.getpName() %></h2>
                    <h3><%= product.getpPrice() %></h3>
                </div>
                <div class="rating">
                    <i class="fa-solid fa-star">4.4</i>
                    <button>Add to cart</button>
                </div>
            </div>
        </div>
    </div>
<% } %>
       
</div>
       </div>
         

      <!-- Footer section -->
      <div class="footer">
        <div class="f">
          <div class="newsletter">
            <div>
              <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" />
            </div>
            <h3>Subscribe to be part of wild zen!</h3>
            <div class="input_div">
              <input type="text" placeholder="sushant@gmail.com" />
              <button>Send</button>
            </div> 
          </div>
          <div class="brands">
            <h2>SHOP BY BRANDS</h2>
            <div class="b_name">
              <ul>
                <li>Apple</li>
                <li>Sony</li>
                <li>Boat</li>
                <li>Hammer</li>
                <li>Sennheiser</li>
              </ul>
            </div>
          </div>
          <div class="brands">
            <h2>CONNECT WITH US</h2>
            <div class="link">
              <a href=""><i class="fa-brands fa-instagram"></i></a>
              <a href=""><i class="fa-brands fa-facebook"></i></a>
              <a href=""><i class="fa-brands fa-twitter"></i></a>
              <a href=""><i class="fa-brands fa-pinterest"></i></a>
            </div>
            <div class="contact">
              <h3>CONTACT US</h3>
              <h4>Email : contact@zenaudio.com</h4>
              <h4>Phone : 9746950627</h4>
            </div>
          </div>
        </div>
      </div>
   
  </body>
</html>

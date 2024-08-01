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
System.out.println("Current Session Username in admin panel: " + userName);

DatabaseController dbController = new DatabaseController();

List<ProductModel> adminProducts = dbController.getAdminProductDetails();

%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/adminpanel.css" />
    <script src="https://kit.fontawesome.com/eed0f9355e.js" crossorigin="anonymous"></script>
    <title>Manage Product by admin</title>
  </head>
  <body>
    <div class="container">
      <!-- sidebar -->
      <div class="sidebar">
        <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" />
        <div class="item">
          <ul>
            <a href="" class="products">
              <i class="fa-solid fa-box"></i>
              <li>Products</li>
            </a>
            <a href="ManageOrders.html">
              <i class="fa-solid fa-bag-shopping"></i>
              <li>Orders</li>
            </a>
            <a href="ManageCustomer.html">
              <i class="fa-solid fa-users"></i>
              <li>Customers</li>
            </a>
          </ul>
        </div>
        <div class="logout">
          <i class="fa-solid fa-right-from-bracket"></i><button>LogOut</button>
        </div>
      </div>
      <!-- siderbar end -->

      <!-- Another sidebar -->
      <div class="bar2">
        <h1>Hi,
         
          <%= userName %>. Welcome to Admin Panel!
        </h1>
        <hr class="" />
        <a href="${pageContext.request.contextPath}/pages/addproducts.jsp">
          <button>Add Product</button>
        </a>
        <div class="product_details">
          <div class="name">
            <h1 >IMG</h1>
            <h1>ID</h1>
            <h1>Name</h1>
            <h1>Description</h1>
            <h1>Stock</h1>
            <h1>Price</h1>
            <h1>DiscountedPrice</h1>
            <h1>LastUpdated</h1>
            <h1>Actions</h1>
          </div>
          <div>
            <% for (ProductModel product : adminProducts){ %>
            <div class="details">
              <h3><img src="${pageContext.request.contextPath}/resources/images<%= product.getImageUrlFromPart() %>" alt="" /></h3>
              <h3><%= product.getProductId() %></h3>
              <h3><%= product.getpName() %></h3>
              <h3><%= product.getpDescription() %></h3>
              <h3><%= product.getpStock() %></h3>
              <h3>Rs. <%= product.getpPrice() %></h3>
              <h3>Rs. <%= product.getpDicountedPrice() %></h3>
              <h3><%= product.getLastUpdated() %></h3>
            	  <i class="fa-solid fa-trash"></i>
            </div>
            <% } %>   
          </div>
        </div>
      </div>
    </div>
    <script src="index.js"></script>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/manageorders.css" />
    <script
      src="https://kit.fontawesome.com/eed0f9355e.js"
      crossorigin="anonymous"
    ></script>
    <title>Manage Order</title>
  </head>
  <body>
    <div class="container">
      <!-- sidebar -->
      <div class="sidebar">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="" />
        <div class="item">
          <ul>
            <a href="ManageProduct.html"
              ><i class="fa-solid fa-box"></i>
              <li>products</li></a
            >
            <a href="" class="ord"
              ><i class="fa-solid fa-bag-shopping"></i>
              <li>Orders</li></a
            >
            <a href="ManageCustomer.html"
              ><i class="fa-solid fa-users"></i>
              <li>Customers</li></a
            >
          </ul>
        </div>
        <div class="logout">
          <i class="fa-solid fa-right-from-bracket"></i><button>LogOut</button>
        </div>
      </div>
      <!-- siderbar end -->

      <!-- Another sidebar -->
      <div class="bar2">
        <h1>Hi, Prayash. Welcome to Admin Panel!</h1>
        <hr class="" />
        <a href="Addproduct.html"> <button>Add Product</button></a>
        <div class="order_details">
          <div class="name">
            <h1>Order No</h1>
            <h1>Product Name</h1>
            <h1>Quantity</h1>
            <h1>Total Price</h1>
            <h1>Order Date</h1>
            <h1>Stautus</h1>
          </div>
          <div>
            <div class="details">
              <h3>101</h3>
              <h3>Boathead 501 Latest</h3>
              <h3>5</h3>
              <h3>Rs. 9000</h3>
              <h3>2023/15/04 11:23:09</h3>
              <div>
                <h3 class="Delivered">Delivered</h3>
                <i class="fa-solid fa-chevron-down"></i>
              </div>
            </div>
            <div class="details">
              <h3>101</h3>
              <h3>Boathead 501 Latest</h3>
              <h3>5</h3>
              <h3>Rs. 9000</h3>
              <h3>2023/15/04 11:23:09</h3>
              <div>
                <h3 class="Pending">Pending</h3>
                <i class="fa-solid fa-chevron-down"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="index.js"></script>
  </body>
</html>

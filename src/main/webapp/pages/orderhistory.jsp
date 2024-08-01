<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/eed0f9355e.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/orderhistory.css" />
    <title>Order History</title>
  </head>
  <body>
    <div class="container">
      <div class="fdiv">
        <h2 class="slogan">
          "Discover Your Signature Sound! Claim 15% off Your Next Earbud
          Upgrade!"
        </h2>
        <!-- navbar -->
        <div class="navbar">
          <div>
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="" />
          </div>
          <div class="cover_div">
            <nav>
              <ul>
                <a href="Home.html"><li>Home</li></a>
                <li>Brands</li>
                <li>Aboutus</li>
              </ul>
            </nav>
            <div class="search_div">
              <div class="search">
                <input type="text" placeholder="search 'ZenAudio'" />
                <i class="fa-solid fa-magnifying-glass"></i>
              </div>
              <div>
                <i class="fa-regular fa-user user"></i>
                <i class="fa-solid fa-cart-shopping"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- fix div -->

      <!-- navbar -->

      <!-- order histiory -->
      <div class="details">
        <div class="s">
          <i class="fa-solid fa-chevron-left"></i>
          <a href="Shoppingcart.html"> <h1>Back to cart</h1></a>
        </div>
        <div class="order">
          <div class="name">
            <h1>Order No</h1>
            <h1>Product Name</h1>
            <h1>Quantity</h1>
            <h1>Total Price</h1>
            <h1>Order Date</h1>
            <h1>Stautus</h1>
          </div>
          <div>
            <div class="order_details">
              <h3>101</h3>
              <h3>Boathead 501 Latest</h3>
              <h3>5</h3>
              <h3>Rs. 9000</h3>
              <h3>2023/15/04 11:23:09</h3>
              <div><h3 class="failed">failed</h3></div>
            </div>
            <div class="order_details">
              <h3>101</h3>
              <h3>Boathead 501 Latest</h3>
              <h3>5</h3>
              <h3>Rs. 9000</h3>
              <h3>2023/15/04 11:23:09</h3>
              <div><h3 class="success">Success</h3></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>

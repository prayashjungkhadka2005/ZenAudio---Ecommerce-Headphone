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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/productdesc.css" />
    <title>Product Description</title>
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
                <a href="Home.html"><li>Home</li></a>
                <li>Brands</li>
                <li>About us</li>
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
      <!-- fix div end -->

      <div class="description">
        <h1>Products / <span>Nirvana Eutopia</span></h1>
        <div class="Product">
          <div class="img_D"><img src="${pageContext.request.contextPath}/resources/images/img3.jpeg" alt="" /></div>
          <div class="des">
            <h3>Nirvana Eutopia</h3>
            <p>
              Headphone Type: Bluetooth Headphones Category: Wireless Headphones
              Driver Size: 40 x 2 mm drivers Music Playtime: 20 Hours Playback
              Frequency: 20Hz-20KHz Charging Time: 60min - 80min
            </p>
            <h4>Rs. 1900</h4>
            <h3>Discounted Price: Rs. 1900</h3>
            <button>Add to cart</button>
          </div>
        </div>
      </div>

      <!-- Brand -->

      <h1 class="title">Shop Brand-Wise</h1>
      <div class="b">
        <div class="brand">
          <div>
            <img src="${pageContext.request.contextPath}/resources/images/boat.jpeg" alt="" />
          </div>

          <div>
            <img src="${pageContext.request.contextPath}/images/hammer.jpeg" alt="" />
          </div>
          <div>
            <img src="${pageContext.request.contextPath}/images/sennheiser.jpeg" alt="" />
          </div>
          <div>
            <img src="${pageContext.request.contextPath}/images/sony.jpeg" alt="" />
          </div>
          <div>
            <img
              src="${pageContext.request.contextPath}/images/apple.jpeg"
              alt=""
              style="width: 70px; height: auto"
            />
          </div>
        </div>
      </div>

      <!-- Footer section -->
      <div class="footer">
        <div class="f">
          <div class="newsletter">
            <div>
              <img src="${pageContext.request.contextPath}/images/img6.png" alt="" />
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
    </div>
  </body>
</html>
    
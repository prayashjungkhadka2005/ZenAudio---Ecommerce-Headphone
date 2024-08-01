<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/addproducts.css" />
    <script
      src="https://kit.fontawesome.com/eed0f9355e.js"
      crossorigin="anonymous"
    ></script>
    <title>Add product</title>
  </head>
  <body>
    <div class="container">
      <!-- sidebar -->
      <div class="sidebar">
        <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" />
        <div class="item">
          <ul>
            <a href="" class="products"
              ><i class="fa-solid fa-box"></i>
              <li>products</li></a
            >
            <a href=""
              ><i class="fa-solid fa-bag-shopping"></i>
              <li>Orders</li></a
            >
            <a href=""
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
<h1>Hi,
    <% 
    Cookie[] cookies = request.getCookies();
    String username = null;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                username = cookie.getValue();
                break;
            }
        }
    }
    %>
    <%= username %>. Welcome to Admin Panel!
</h1>

        <hr  />
        
        <div class="product_details">
        <form action="${pageContext.request.contextPath}/AddProductsServlet" method="post" enctype="multipart/form-data">
        <div class="product_name">
            <label for="">Enter Products Name</label>
            <input
              type="text"
              placeholder="Boathead 5560 Series 10"
              class="name" name="productName"
            />
          </div>
          <!-- description -->
          
          <div class="product_name">
            <label for="">Enter Products Description</label>
            <input type="text" class="descriptionn" name="productDescription"/>
          </div>
          <div class="table">
            <div class="stock">
              <h2>Stock</h2>
              <input type="text" name="productStock"/>
            </div>
            <div class="price">
              <h2>Price</h2>
              <input type="text" name="productPrice"/>
            </div>
            <div class="description">
              <h2>Discounted Price</h2>
              <input type="text" name="discountedPrice"/>
            </div>
          </div>
          <!-- galley section -->
          <div class="gallery" id="gallery">
            <div class="img-div">
              <img id="selected-image" src="${pageContext.request.contextPath}/resources/images/gallery.png" alt="" />
              <input type="file" class="form-control-file" id="image" name="image" required />
            </div>
            <button type="submit">Publish</button> 
          </div>
        </form>
          
        </div>
      </div>
    </div>
    <script src="index.js"></script>
  </body>
</html>

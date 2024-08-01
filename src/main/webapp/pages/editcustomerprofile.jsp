<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/editcustomerprofile.css" />
    <script
      src="https://kit.fontawesome.com/eed0f9355e.js"
      crossorigin="anonymous"
    ></script>
    <title>Edit User Profile</title>
  </head>
  <body>
    <div class="container">
      <!-- sidebar -->
      <div class="sidebar">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="" />
        <div class="item">
          <ul>
            <a href="" class="products"
              ><i class="fa-solid fa-box"></i>
              <li>products</li></a
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
        <h1>Hi, Prayash. Welcome to your profile!</h1>
        <hr />
        <div class="product_details">
          <div class="product_name">
            <label for="">Username</label>
            <input type="text" placeholder="mysticeeast" class="name" />
          </div>
          <!-- Full name -->
          <div class="product_name">
            <label for="">Full Name</label>
            <input type="text" placeholder="Prayash Jung Khadka" class="name" />
          </div>
          <!-- email -->
          <div class="product_name">
            <label for="">Email</label>
            <input
              type="email"
              placeholder="prayashjungkhadka@gmail.com"
              class="name"
            />
          </div>
        </div>
        <a href=""><button class="save_btn">Save</button></a>
      </div>
    </div>
  </body>
</html>
    
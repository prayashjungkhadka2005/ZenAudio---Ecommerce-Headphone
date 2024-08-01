<%@page import="model.ZenAudioModel"%>
<%@page import="util.StringUtils"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/register.css" />
  </head>
  <body>
    <div class="w-full">
      <div class="container">
        <div class="grid">
          <div class="image_container">
            <img src="${pageContext.request.contextPath}/resources/images/img5.jpeg" alt="" class="register_img" />
          </div>
          <div class="content">
            <div class="title">
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
              <h1>WELCOME BACK</h1>
              <p>Welcome back! Please enter your details.</p>
            </div>
            <div class="form-container">
              <form action="${pageContext.request.contextPath}/LoginServlet" method="post" >
                <div class="input-group">
                  <input type="text" id="name" placeholder="Username" name="userName" />
                </div>

                <div class="input-group">
                  <input type="password" id="password" placeholder="Password" name="password" />
                </div>
                
                <div class="forgot">
                  <span
                    ><input type="checkbox" name="" id="" />Remember me</span
                  >
                  <p>forgot password</p>
                  <p> Haven't register yet? <span > <a href="${pageContext.request.contextPath}/pages/register.jsp">Signup</a> </span> </p>
                </div>
                <div class="button-group">
                  <button type="submit">Sign in</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>



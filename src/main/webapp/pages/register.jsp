<%@page import="model.ZenAudioModel"%>
<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/register.css" />
    <title>Register</title>
</head>
<body>
    <div class="w-full">
        <div class="container">
            <div class="grid">
                <div class="image_container">
                    <img src="${pageContext.request.contextPath}/resources/images/img2.jpeg" alt="Registration Image" class="register_img">
                    
                </div>
                <div class="content">
                    <div class="title">
                        <h1>Welcome to ZenAudio</h1>
                    </div>
                     <%
        String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
    
        
        if (errorMessage !=null && !errorMessage.isEmpty()) {
    %>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
        <% 
        }
        %>
                    <div class="form-container">
                        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post" >
                            <div class="input-group">
                                <input type="text"  name="userName" placeholder="Username" required/>
                            </div>
                            <div class="input-group">
                                <input type="text" id="email" name="email" placeholder="Email" required/>
                            </div>
                            <div class="input-group">
                                <label for="role">Role:</label>
                                <select id="role" name="role">
                                    <option value="admin" name="admin">Admin</option>
                                    <option value="customer" name="customer">Customer</option>
                                </select>
                            </div>
                            <div class="input-group">
                                <input type="password" id="password" name="password" placeholder="Password" required/>
                            </div>
                            <div class="input-group">
                                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required/>
                            </div>
                            <div class="button-group">
                                <button type="submit">Create Account</button>
                            </div>
                        </form>
                        <p>
                            Already have an account?
                            <a href="${pageContext.request.contextPath}/pages/login.jsp" class="login-link">Log in</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

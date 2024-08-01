package model;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ZenAudioModel
 */
@WebServlet("/ZenAudioModel")
public class ZenAudioModel extends HttpServlet {
	private String userName;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private LocalDateTime registeredAt;
    
   

    public ZenAudioModel( String userName, String email, String password, String role, LocalDateTime registeredAt) {
       
    	this.userName = userName;
        this.email = email;
        this.password = password;
        this.registeredAt = registeredAt;
        this.role = role;
    }
    
   
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDateTime getRegisteretAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

}

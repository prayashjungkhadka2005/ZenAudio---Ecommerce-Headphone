package model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ProductModel
 */
@WebServlet("/ProductModel")
public class ProductModel extends HttpServlet {
	private String imageUrlFromPart;
	private String pName;
	private String pDescription;
	private int pStock;
	private int pPrice;
	private int pDicountedPrice;
	private LocalDateTime lastUpdated;
	int productId;
	
	public ProductModel(int productId ,String imageUrlFromPart, String pName, String pDescription, int pStock, int pPrice, int pDiscountedPrice, LocalDateTime lastUpdated ) {
		this.productId = productId;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pStock = pStock;
		this.pPrice = pPrice;
		this.pDicountedPrice = pDiscountedPrice;
		this.lastUpdated = lastUpdated;
		this.imageUrlFromPart = imageUrlFromPart;
	}
	
	

	public ProductModel(Part imagePart, String pName, String pDescription, int pStock, int pPrice, int pDiscountedPrice, LocalDateTime lastUpdated ) {
		this.pName = pName;
		this.pDescription = pDescription;
		this.pStock = pStock;
		this.pPrice = pPrice;
		this.pDicountedPrice = pDiscountedPrice;
		this.lastUpdated = lastUpdated;
		this.imageUrlFromPart = getImageUrl(imagePart);
	}
	
	
	
	public ProductModel() {
		
	}

	public int getProductId() {
		return productId;
	}
	

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpDicountedPrice() {
		return pDicountedPrice;
	}

	public void setpDicountedPrice(int pDicountedPrice) {
		this.pDicountedPrice = pDicountedPrice;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	private String getImageUrl(Part imagePart) {
	    String savePath = "C:/Users/User/eclipse-workspace/ZenAudioProjects/src/main/webapp/resources/images/"; // Specify the absolute path to the images folder
	    File fileSaveDir = new File(savePath);
	    if (!fileSaveDir.exists()) {
	        fileSaveDir.mkdirs(); // Use mkdirs() to create parent directories if they don't exist
	    }
	    String contentDisp = imagePart.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    String imageUrlFromPart = "default.jpg"; // Default image URL

	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
	            // Extract only the filename from the full path (if present)
	            imageUrlFromPart = imageUrlFromPart.substring(imageUrlFromPart.lastIndexOf('\\') + 1);
	            imageUrlFromPart = imageUrlFromPart.substring(imageUrlFromPart.lastIndexOf('/') + 1);
	            break;
	        }
	    }
	    return imageUrlFromPart;
	}

	
	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}

	
	
	public void setImageUrlFromPart(Part imagePart) {
	    this.imageUrlFromPart = getImageUrl(imagePart);
	}
	
	public ProductModel(String pName, int pPrice, String imageUrlFromPart) {
		this.pName = pName;
		this.pPrice = pPrice;
		this.imageUrlFromPart = imageUrlFromPart;
		
	}
	

}

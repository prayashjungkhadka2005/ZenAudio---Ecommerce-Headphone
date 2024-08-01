package model;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServlet;

public class CartModel extends HttpServlet  {
	
	private int cartId;
	private LocalDateTime  addedAt;
	private int userId;
	private int productId;
	private String productName;
	private String productDescription;
	private int productQuantity;
	private int productPrice;
	private int productStock;
	private String imageUrlFromPart;
	
	
	
	
	
	public CartModel(int cartId, LocalDateTime addedAt, String productName, String productDescription,
			int productStock, int productPrice , String imageUrlFromPart) {
	
	this.addedAt = addedAt;
this.cartId = cartId;
	this.productName = productName;
	this.productDescription = productDescription;
	
	this.productPrice = productPrice;
	this.productStock = productStock;
	this.imageUrlFromPart = imageUrlFromPart;
}

	public int getCardId() {
		return cartId;
	}
	
	public void setCardId(int cardId) {
		this.cartId = cartId;
	}

	public String getProductName() {
	return productName;
}

	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}

	
public void setProductName(String productName) {
	this.productName = productName;
}


public String getProductDescription() {
	return productDescription;
}


public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}


public int getProductQuantity() {
	return productQuantity;
}


public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}


public int getProductPrice() {
	return productPrice;
}


public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}


public int getProductStock() {
	return productStock;
}


public void setProductStock(int productStock) {
	this.productStock = productStock;
}


	public CartModel(LocalDateTime addedAt, int userId, int productId) {
		
		this.addedAt = addedAt;
		this.userId = userId;
		this.productId = productId;
	}
	
	public LocalDateTime getAddedAt() {
		return addedAt;
	}
	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}

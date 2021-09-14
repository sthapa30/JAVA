package com.uta.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class ProductDTO {
	
	@Id
	@Column(name="PRODUCT_ID")
	private String productID;
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
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
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_DESC")
	private String productDescription;
	
	@Column(name="USER_ID")
	private String userID;

}

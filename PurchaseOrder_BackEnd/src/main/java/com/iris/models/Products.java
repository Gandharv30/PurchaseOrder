package com.iris.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="products")

public class Products {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
    @NotNull
    @Size(min=1)
	private int productId;
	
	@Column(name="product_name", unique=true)
	   @NotNull
	private String productName;
	
	@Column(name="product_desc")
	   @NotNull
	private String productDesc;
	
	@Column(name="product_price")
	   @NotNull
	private double productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDes() {
		return productDesc;
	}
	public void setProductDes(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + "]";
	}
	
	
	
}


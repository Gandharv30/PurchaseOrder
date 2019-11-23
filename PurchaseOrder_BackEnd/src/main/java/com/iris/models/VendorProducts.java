package com.iris.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vendor_Product_Table")
public class VendorProducts {
@Id
@GeneratedValue
private int id;
 private int vendorProductId;
 private int quantity;
 private int vendorId;
 
 @OneToOne
 @JoinColumn(name="vendorProductId",insertable=false,updatable=false)
 Products productObj;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getVendorProductId() {
	return vendorProductId;
}

public void setVendorProductId(int vendorProductId) {
	this.vendorProductId = vendorProductId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getVendorId() {
	return vendorId;
}

public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}

public Products getProductObj() {
	return productObj;
}

public void setProductObj(Products productObj) {
	this.productObj = productObj;
}

@Override
public String toString() {
	return "VendorProducts [id=" + id + ", vendorProductId=" + vendorProductId + ", quantity=" + quantity
			+ ", vendorId=" + vendorId + ", productObj=" + productObj + "]";
}
 
 

}

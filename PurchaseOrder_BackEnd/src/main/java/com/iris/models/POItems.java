package com.iris.models;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PO_Items_New")
public class POItems {
	
	@Id
	@GeneratedValue
	private int purchaseOrderItemId;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Products productObj;
	
	private int quantity;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="purchaseOrderId")
	private PurchaseOrder purchaseOrderObj;
	
	@Transient
	private int productId;

	public int getPurchaseOrderItemId() {
		return purchaseOrderItemId;
	}

	public void setPurchaseOrderItemId(int purchaseOrderItemId) {
		this.purchaseOrderItemId = purchaseOrderItemId;
	}

	public Products getProductObj() {
		return productObj;
	}

	public void setProductObj(Products productObj) {
		this.productObj = productObj;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PurchaseOrder getPurchaseOrderObj() {
		return purchaseOrderObj;
	}

	public void setPurchaseOrderObj(PurchaseOrder purchaseOrderObj) {
		this.purchaseOrderObj = purchaseOrderObj;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "POItems [purchaseOrderItemId=" + purchaseOrderItemId + ", productObj=" + productObj + ", quantity="
				+ quantity + ", productId=" + productId + "]";
	}

	

	
	

}
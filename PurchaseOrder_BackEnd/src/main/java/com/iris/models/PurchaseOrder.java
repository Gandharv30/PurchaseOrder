package com.iris.models;
import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="po_order_New")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	@Column(name="po_Id")
	private int poId;
	
	@ManyToOne
	@JoinColumn(name="User_Id")
	private User buyerObj;
	
	@ManyToOne
	@JoinColumn(name="seller_Id")
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<POItems> poItemsObj;


	
	@Column(name="Po_Status")
    private String status;
    
	@Column(name="Created_Date")
    private LocalDate createdDate;

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public User getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(User buyerObj) {
		this.buyerObj = buyerObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<POItems> getPoItemsObj() {
		return poItemsObj;
	}

	public void setPoItemsObj(List<POItems> poItemsObj) {
		this.poItemsObj = poItemsObj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", buyerObj=" + buyerObj + ", sellerObj=" + sellerObj + ", poItemsObj="
				+ poItemsObj + ", status=" + status + ", createdDate=" + createdDate + "]";
	}

	
	
	
}

package com.iris.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tblUsers")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="User_Id")
	private int userId;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name="Mobile_no")
	private int mobileNumber;
	@Column(name="Address")
	private String addressLine;
	
	private String email;
	
	@Column(name="IsActive")
	private String IdActiveFlag;
	
	@Column(name="RoleId")
	private int roleId;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="Created_by")
	private String createdBy;
	
	@Column(name="Created_date")
	private LocalDate createdDate;
	
	@Column(name="Updated_date")
	private LocalDate updatedDate;
	
	@Column(name="Updated_by")
	private String updatedBy;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdActiveFlag() {
		return IdActiveFlag;
	}

	public void setIdActiveFlag(String idActiveFlag) {
		IdActiveFlag = idActiveFlag;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mobileNumber=" + mobileNumber + ", addressLine="
				+ addressLine + ", email=" + email + ", IdActiveFlag=" + IdActiveFlag + ", roleId=" + roleId
				+ ", userPassword=" + userPassword + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	
	
	
}

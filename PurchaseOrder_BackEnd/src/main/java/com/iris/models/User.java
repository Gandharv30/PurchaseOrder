package com.iris.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user_table")
public class User {
	@Id
    @GeneratedValue
    @NotNull 
    private int UserId;
    
	@NotEmpty
	@Size(min=4,max=30)
    private String userName;

	@NotEmpty(message="Not a valid emailId")
	@Pattern(message = "Invalid email id", regexp = "^.+@.+\\..+$")
    private String email;

	@NotEmpty
	@Size(min=2,message="password can not be less than 2 characters")
    private String userPassword;

	@NotEmpty(message="can not be empty")
    private String address;
	@NotEmpty(message="can not be empty")
	@Size(min=10,max=10)
	@Pattern(regexp=("[^0-9](10)"))
    private String mobileNumber;
	
    private String IsActive;

    private LocalDate createdDate;

    private String createdBy;

    private String updateBy;

    private LocalDate updatedDate;
    
    private String role;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", userName=" + userName + ", email=" + email + ", userPassword="
				+ userPassword + ", address=" + address + ", mobileNumber=" + mobileNumber + ", IsActive=" + IsActive
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updateBy=" + updateBy
				+ ", updatedDate=" + updatedDate + ", role=" + role + "]";
	}

	
    
    


}

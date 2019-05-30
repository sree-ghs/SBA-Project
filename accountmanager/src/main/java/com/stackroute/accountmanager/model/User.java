package com.stackroute.accountmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class User {

	@Id
    private String userId;
    private String userPassword;
    
    private String firstName;
    private String lastName;
    private String email;
//	private String userRole;
//	private Date userAddedDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public String getUserRole() {
//		return userRole;
//	}
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}
//	public Date getUserAddedDate() {
//		return userAddedDate;
//	}
//	public void setUserAddedDate(Date userAddedDate) {
//		this.userAddedDate = userAddedDate;
//	}
    
  

    


}

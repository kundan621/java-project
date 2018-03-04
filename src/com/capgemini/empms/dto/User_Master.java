package com.capgemini.empms.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class User_Master 
{
	@Id
    @NotEmpty(message="UserID *")
	private String userId;

	private String userName;
	@NotEmpty(message="Password *")
	private String userPassword;
	@NotEmpty(message="Role *")
	private String userType;
	
	
	@Override
	public String toString() 
	{
		return "User_Master [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userType=" + userType
				+ "]";
	}
	
	public String getUserId() 
	{
		return userId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	public String getUserType() 
	{
		return userType;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}	
}

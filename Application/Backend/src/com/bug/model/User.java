package com.bug.model;
public class User {
    private int userId;
    private String name;
    private String email;
    private UserType userType;

   


public enum UserType {
    PROJECT_MANAGER,
    DEVELOPER,
    TESTER
}




public User() {
	super();
	// TODO Auto-generated constructor stub
}




public User(int userId, String name, String email, UserType userType) {
	super();
	this.userId = userId;
	this.name = name;
	this.email = email;
	this.userType = userType;
}




public int getUserId() {
	return userId;
}




public void setUserId(int userId) {
	this.userId = userId;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public UserType getUserType() {
	return userType;
}




public void setUserType(UserType userType) {
	this.userType = userType;
}




@Override
public String toString() {
	return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", userType=" + userType + "]";
}

}
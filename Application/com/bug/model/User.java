package com.bug.model;

public abstract class User {
	private String name;
	private int uID;
	private String email;
	protected String typeUser;
	
	
	
	public User(String name, int uID, String email) {
		super();
		this.name = name;
		this.uID = uID;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTypeUser() {
		return typeUser;
	}
	
	public abstract void setTypeUser();

		
	

}

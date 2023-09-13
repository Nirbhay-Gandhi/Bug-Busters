package com.bug.model;
import java.util.*;

public class Dev extends User {
	
	private static final String typeOFUSr = "Developer";
	
	public Dev(String name, int uID, String email, int numberOfProjects, Set<Bugs> bugsAssigned) {
		super(name, uID, email);
		this.setTypeUser();
		this.numberOfProjects = numberOfProjects;
		bugsAssigned = new HashSet<Bugs>();
	}

	private int numberOfProjects;
	private Set<Bugs> bugsAssigned;

	@Override
	public void setTypeUser() {
		this.typeUser = typeOFUSr;
	}
	
	

}

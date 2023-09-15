package com.bug.model;

public class ProjectManager extends User {

	private int currentProject;
	private String Dept;
	private static final String typeOFUSr = "ProjectManager";
	public ProjectManager(String name, int uID, String email, int currentProject, String dept) {
		super(name, uID, email);
		this.currentProject = currentProject;
		Dept = dept;
	}



	@Override
	public void setTypeUser() {
		this.typeUser = typeOFUSr;
	}

}

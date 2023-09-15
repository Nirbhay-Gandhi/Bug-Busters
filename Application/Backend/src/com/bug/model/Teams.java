package com.bug.model;
import java.util.List;

	
	public class Teams {
	    private int teamId;
	    private User projectManager;
	    private List<User> developers;
	    private User tester;

	    // Constructors, getters, and setters

	    

	    public Teams(int teamId, User projectManager, List<User> developers, User tester) {
	        this.teamId = teamId;
	        this.projectManager = projectManager;
	        this.developers = developers;
	        this.tester = tester;
	    }

	    public Teams() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getTeamId() {
	        return teamId;
	    }

	    public void setTeamId(int teamId) {
	        this.teamId = teamId;
	    }

	    public User getProjectManager() {
	        return projectManager;
	    }

	    public void setProjectManager(User projectManager) {
	        this.projectManager = projectManager;
	    }

	    public List<User> getDevelopers() {
	        return developers;
	    }

	    public void setDevelopers(List<User> developers) {
	        this.developers = developers;
	    }

	    public User getTester() {
	        return tester;
	    }

	    public void setTester(User tester) {
	        this.tester = tester;
	    }
	}

package com.bug.businessLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bug.dao.BugsIntf;
import com.bug.dao.ProjectIntff;
import com.bug.dao.UserIntf;
import com.bug.model.Bugs;
import com.bug.model.Project;
import com.bug.model.User;
import com.bug.model.Bugs.bugStatus;
import com.bug.model.Project.ProjectStatus;
import com.bug.model.User.UserType;

public class BussinessLayer{
	

	    private BugsIntf bugDAO;
	    private ProjectIntff projectDAO;
	    private UserIntf userDAO;

	    
	    // Project Manager-related operations

	   /* public List<Bugs> viewAllBugs() {
	        return bugDAO.getAllBugs();
	    }*/

	    public BussinessLayer() {
			super();
			// TODO Auto-generated constructor stub
		}



		public void assignBugToDeveloper(Bugs bug, User user) {
	        if (user.getUserType() == UserType.DEVELOPER) {
	         
	            bug.setAssignedTo("DEVELOPER");
	            bug.setStatus(bug.getStatus().OPEN );
	            bugDAO.updateBug(bug);
	        } else {
	            // Handle the case where the user is not a developer
	            throw new IllegalArgumentException("Only developers can be assigned bugs.");
	        }
	    }



	    public void closeBug(Bugs bug, String notes) {
	        bug.setStatus(bug.getStatus().CLOSED);
	        bug.setClosedOn(new Date());
	        bugDAO.updateBug(bug);
	    }

	    public Project createProject(int projectId, String projectName, String description, Date startDate, ProjectStatus status, int teamId) {
	        Project project = new Project( projectId, projectName, description,startDate, status, teamId);
	        projectDAO.createProject(project);
	        return project;
	    }

	    public void editProject(Project project) {
	        projectDAO.updateProject(project);
	    }

	    public void markProjectAsCompleted(Project project) {
	        project.setStatus(ProjectStatus.COMPLETED);
	        projectDAO.updateProject(project);
	    }

	    // Developer-related operations

	   

	    public void updateBugStatus(Bugs bug, bugStatus status) {
	        bug.setStatus(status);
	        bugDAO.updateBug(bug);
	    }

	    // Tester-related operations

	    public void reportBug(Bugs bug,Project project) {
	        bug.setCreatedBy("tester");
	        bugDAO.addBug(bug);
	    }

	    public List<Bugs> viewOwnReportedBugs(User user) {
	        return bugDAO.getBugsReportedByUser(user.getUserType().TESTER);
	    }

	    public void editBugReport(Bugs bug) {
	        // Allow testers to edit their bug reports until assigned to a developer
	        if (bug.getStatus() != bugStatus.OPEN) {
	            bugDAO.updateBug(bug);
	        }
	    }
	}


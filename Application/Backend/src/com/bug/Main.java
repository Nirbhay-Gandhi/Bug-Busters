package com.bug;


import java.sql.Date;
import java.util.List;

import com.bug.*;
import com.bug.businessLayer.BussinessLayer;
import com.bug.dao.BugsIntf;
import com.bug.dao.ProjectIntff;
import com.bug.dao.UserIntf;
import com.bug.model.Bugs;
import com.bug.model.Bugs.bugStatus;
import com.bug.model.Project;
import com.bug.model.User;
import com.bug.model.User.UserType;
public class Main {
	
	    public static void main(String[] args) {
	        

	        // Create an instance of the BusinessLayer
	        BussinessLayer businessLayer = new BussinessLayer();

	        // Simulate user interactions

	        // Project Manager
	        User projectmanager = new User(1, "Himanshi Lalwani", "himanshi@example.com", UserType.PROJECT_MANAGER);
	        Project project = businessLayer.createProject(1, "Project A", "Description A", new Date(), ProjectStatus.OPEN, 1);

	        // Tester
	        User tester = new User(2, "Alice Smith", "alice@example.com", UserType.TESTER);
	        Bugs bug1 = new Bugs(1, "Bug 1", "Description 1", new Date(), bugStatus.OPEN, 1, "tester");
	        businessLayer.reportBug(bug1, project);

	        // Developer
	        User developer = new User(3, "Bob Johnson", "bob@example.com", UserType.DEVELOPER);
	        businessLayer.assignBugToDeveloper(bug1, developer);

	        // Project Manager closes the bug
	        businessLayer.closeBug(bug1, "Bug fixed.");

	        // View bugs reported by a tester
	        List<Bugs> testerBugs = businessLayer.viewOwnReportedBugs(tester);
	        for (Bugs bug : testerBugs) {
	            System.out.println("Reported Bug: " + bug.getTitle());
	        }

	        // View all bugs
	        List<Bugs> allBugs = bugsDAO.getAllBugs();
	        for (Bugs bug : allBugs) {
	            System.out.println("Bug ID: " + bug.getId() + ", Status: " + bug.getStatus());
	        }
	    }
	}



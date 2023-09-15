package com.bug.model;

import java.util.Date;
import java.util.List;

import java.util.Date;

public class Project {
    private int projectId;
    private String projectName;
    private String description;
    private Date startDate;
    private ProjectStatus status;
    private int teamId; // Represents the team associated with the project

   
    // Constructors, getters, and setters
    public enum ProjectStatus {
        IN_PROGRESS,
        COMPLETED
    }


    public Project() {
        // Default constructor
    }

    public Project(int projectId, String projectName, String description, Date startDate, ProjectStatus status, int teamId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.status = status;
        this.teamId = teamId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", startDate=" + startDate + ", status=" + status + ", teamId=" + teamId + "]";
	}
    
}

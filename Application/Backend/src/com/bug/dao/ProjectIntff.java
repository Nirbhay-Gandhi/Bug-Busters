package com.bug.dao;
import java.util.List;

import com.bug.model.Project;
import com.bug.model.Project.ProjectStatus;



public interface ProjectIntff {
    Project getProjectById(int projectId);

    List<Project> getAllProjects();

    List<Project> getProjectsByStatus(ProjectStatus status);

    void createProject(Project project);

    void updateProject(Project project);

    void deleteProject(int projectId);
}


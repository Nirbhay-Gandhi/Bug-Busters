package com.bug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bug.model.Project;
import com.bug.model.Project.ProjectStatus;

public class ProjectDaoImpl implements ProjectIntff {
    private Connection connection; // Your database connection

    public ProjectDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Project getProjectById(int projectId) {
        String sql = "SELECT * FROM projects WHERE project_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createProjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Project not found
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> allProjects = new ArrayList<>();
        String sql = "SELECT * FROM projects";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allProjects.add(createProjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProjects;
    }

    @Override
    public List<Project> getProjectsByStatus(ProjectStatus status) {
        List<Project> projectsByStatus = new ArrayList<>();
        String sql = "SELECT * FROM projects WHERE status = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, status.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                projectsByStatus.add(createProjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectsByStatus;
    }

    @Override
    public void createProject(Project project) {
        String sql = "INSERT INTO projects (project_name, description, start_date, status, team_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
            preparedStatement.setString(4, project.getStatus().toString());
            preparedStatement.setInt(5, project.getTeamId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProject(Project project) {
        String sql = "UPDATE projects SET project_name = ?, description = ?, start_date = ?, status = ? WHERE project_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
            preparedStatement.setString(4, project.getStatus().toString());
            preparedStatement.setInt(5, project.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(int projectId) {
        String sql = "DELETE FROM projects WHERE project_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Project createProjectFromResultSet(ResultSet resultSet) throws SQLException {
        Project project = new Project();
        project.setProjectId(resultSet.getInt("project_id"));
        project.setProjectName(resultSet.getString("project_name"));
        project.setDescription(resultSet.getString("description"));
        project.setStartDate(resultSet.getDate("start_date"));
        project.setStatus(ProjectStatus.valueOf(resultSet.getString("status")));
        project.setTeamId(resultSet.getInt("team_id"));
        return project;
    }
}

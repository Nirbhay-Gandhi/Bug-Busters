package com.bug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bug.model.Teams;
import com.bug.model.User;

public class TeamsDaoImpl implements TeamsIntff {
    private Connection connection; // Your database connection

    public TeamsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Teams getTeamById(int teamId) {
        String sql = "SELECT * FROM teams WHERE team_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teamId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createTeamFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Team not found
    }

    @Override
    public List<Teams> getAllTeams() {
        List<Teams> allTeams = new ArrayList<>();
        String sql = "SELECT * FROM teams";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allTeams.add(createTeamFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTeams;
    }

    @Override
    public void createTeam(Teams team) {
        String sql = "INSERT INTO teams (project_manager_id, tester_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, team.getProjectManager().getUserId());
            preparedStatement.setInt(2, team.getTester().getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTeam(Teams team) {
        String sql = "UPDATE teams SET project_manager_id = ?, tester_id = ? WHERE team_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, team.getProjectManager().getUserId());
            preparedStatement.setInt(2, team.getTester().getUserId());
            preparedStatement.setInt(3, team.getTeamId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeam(int teamId) {
        String sql = "DELETE FROM teams WHERE team_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teamId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Teams createTeamFromResultSet(ResultSet resultSet) throws SQLException {
        Teams team = new Teams();
        team.setTeamId(resultSet.getInt("team_id"));
        
        // Assuming you have User objects representing project managers and testers
        User projectManager = getUserById(resultSet.getInt("project_manager_id"));
        User tester = getUserById(resultSet.getInt("tester_id"));
        
        team.setProjectManager(projectManager);
        team.setTester(tester);
        return team;
    }

    // Helper method to retrieve a User by ID (you need to implement this)
    private User getUserById(int userId) {
        // Implement this method to fetch a User by their ID from the database
        // You can use a UserDAO or a similar mechanism
        return null;
    }
}

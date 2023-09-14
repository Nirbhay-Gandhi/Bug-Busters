package com.bug.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bug.*;
import com.bug.jdbcConnection.JdbcConnection;
import com.bug.model.User;
import com.bug.model.User.UserType;


public class UserDaoImpl implements UserIntf {
    // Assuming you have a database connection pool or manage connections elsewhere
	JdbcConnection c=new JdbcConnection();
	Connection connection = c.getConnection();
   
    @Override
    public User getUserById(int userId) {
    	
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c.closeConnection(connection);
        return null; // User not found
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c.closeConnection(connection);
        return null; // User not found
    }

    @Override
    public List<User> getUsersByType(UserType userType) {
        List<User> usersByType = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE user_type = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userType.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usersByType.add(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        c.closeConnection(connection);
        return usersByType;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUsers.add(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c.closeConnection(connection);
        return allUsers;
    }

    
  
    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c.closeConnection(connection);
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setUserType(UserType.valueOf(resultSet.getString("user_type")));
        c.closeConnection(connection);
        return user;
       
    }

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		  String sql = "INSERT INTO users (name, email, user_type) VALUES (?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getUserType().toString());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        c.closeConnection(connection);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE users SET name = ?, email = ?, user_type = ? WHERE user_id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getUserType().toString());
	            preparedStatement.setInt(4, user.getUserId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        c.closeConnection(connection);
	}
	
}


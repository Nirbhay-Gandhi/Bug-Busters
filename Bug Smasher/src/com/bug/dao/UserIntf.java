package com.bug.dao;
import java.util.List;

import com.bug.model.User;
import com.bug.model.User.UserType;



public interface UserIntf {
    User getUserById(int userId);
    
    User getUserByEmail(String email); // New method to retrieve user by email
    
    List<User> getUsersByType(UserType userType);
    
    List<User> getAllUsers();
    
    void createUser(User user);
    
    void updateUser(User user);
    
    void deleteUser(int userId);
}



package org.patsimas.school.model.dao;

import java.util.List;

import org.patsimas.school.model.entity.User;


public interface UserDAO {
    
    User create(String name, String password);
    
    void update(User user);
    
    void delete(User user);
    
    User getUserById(long id) throws Exception;
    
    User getUser(String username, String password) throws Exception;
    
    List<User> getAllUsers() throws Exception;
        
}

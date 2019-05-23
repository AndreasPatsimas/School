package org.patsimas.school.model.jdbc;

import java.util.List;

import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.entity.User;


public class UserDAOImpl implements UserDAO {

	public User create(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	public User getUserById(long id) throws Exception {
		User user = DatabaseHelper.fetchUserOrNull("select * from user where id = ?", id);
	    if (user == null) {
	        throw new Exception("Invalid user id: " + id);
	    }
	    return user;
	}

	public User getUser(String username, String password) throws Exception {
	    User user = DatabaseHelper.fetchUserOrNull("select * from users where username = ? and password = ?", username, password);
	    if (user == null) {
	        throw new Exception("Invalid username / password");
	    }
	    else {
	        return user;
	    }
	}

	public List<User> getAllUsers() throws Exception {
		return DatabaseHelper.fetchUsers("select * from users");
	}          
    
}




     


package org.patsimas.school.model.service_impl;

import java.util.List;

import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.service.UserService;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;
	
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
		
		return userDAO.getUserById(id);
	}

	public User getUser(String username, String password) throws Exception {
		
		return userDAO.getUser(username, password);
	}

	public List<User> getAllUsers() throws Exception {
		
		return userDAO.getAllUsers();
	}

}

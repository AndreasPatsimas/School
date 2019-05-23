package org.patsimas.school.model.service;

import java.util.List;

import org.patsimas.school.model.entity.User;

public interface UserService {

	User create(String name, String password);

	void update(User user);

	void delete(User user);

	User getUserById(long id) throws Exception;

	User getUser(String username, String password) throws Exception;

	List<User> getAllUsers() throws Exception;
}

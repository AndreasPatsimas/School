package org.patsimas.school.model.jdbc;

import org.patsimas.school.model.dao.UserRoleDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.entity.UserRole;

public class UserRoleDAOImpl implements UserRoleDAO {

	public void saveRoleUser(UserRole roleUser) {
		// TODO Auto-generated method stub
		
	}

	public UserRole getRoleUserById(Long uid, User user) throws Exception {
		
		UserRole userRole = DatabaseHelper.fetchUserRoleOrNull("select rid from user_roles where uid = ?", uid, user);
		
		if (userRole == null) {
	        throw new Exception("Invalid user id: " + uid);
	    }
	    
		return userRole;
	}

	public void changeRole(UserRole roleUser) {
		// TODO Auto-generated method stub
		
	}

}

package org.patsimas.school.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.patsimas.school.controllers.LoginHelper;
import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.dao.UserRoleDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.entity.UserRole;
import org.patsimas.school.model.jdbc.UserDAOImpl;
import org.patsimas.school.model.jdbc.UserRoleDAOImpl;

public class UserListAPI extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDao = new UserDAOImpl();
		
		UserRoleDAO userRoleDao = new UserRoleDAOImpl();
		
		resp.setContentType("application/json; charset=utf-8");
        
        try {
        	User user = LoginHelper.getLoggedInDirectorFromCookie(req);
        	
        	UserRole usr = userRoleDao.getRoleUserById(user.getId(), user);
        	
        	if(usr.getRole().getRid() != 1) {
        		throw new Exception("Not authorized");
        	}
        	
			List<User> users = userDao.getAllUsers();
			
			JsonHelper.writeJson(resp.getWriter(), users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}

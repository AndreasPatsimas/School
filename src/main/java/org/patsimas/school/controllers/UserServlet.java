package org.patsimas.school.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.dao.UserRoleDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.entity.UserRole;
import org.patsimas.school.model.jdbc.UserDAOImpl;
import org.patsimas.school.model.jdbc.UserRoleDAOImpl;


@WebServlet("/users")
public class UserServlet extends VelocityViewServlet {

	@Override
	protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
		
		UserDAO ud = new UserDAOImpl();
		
		UserRoleDAO urd = new UserRoleDAOImpl();
		
		List<User> userList = null;
		
		List<UserRole> userRoleList = new ArrayList();
		
		UserRole userRole = new UserRole();
		
		try {
			userList = ud.getAllUsers();
			for(User user : userList) {
				userRole = urd.getRoleUserById(user.getId(), user);
				userRoleList.add(userRole);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(userRoleList);
		ctx.put("users", userRoleList);
		
		return getTemplate("users.html");
	}

	
}

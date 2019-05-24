package org.patsimas.school.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.dao.UserRoleDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.entity.UserRole;
import org.patsimas.school.model.jdbc.UserDAOImpl;
import org.patsimas.school.model.jdbc.UserRoleDAOImpl;

@WebServlet("/authenticate")
public class LoginServlet extends VelocityViewServlet {

	@Override
	protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
		
		UserDAO ud = new UserDAOImpl();
		
		UserRoleDAO urd = new UserRoleDAOImpl();
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		try {
			User user = ud.getUser(username, password);
			
			UserRole userRole = urd.getRoleUserById(user.getId(), user);
			
			session.setAttribute("user", user);
			
			ctx.put("user", user);
			
			if(userRole.getRole().getRid() == 1) {
				List<User> userList = ud.getAllUsers();
				List<UserRole> userRoleList = new ArrayList();
				UserRole roleUser = new UserRole();
				for(User userData : userList) {
					roleUser = urd.getRoleUserById(user.getId(), userData);
					userRoleList.add(roleUser);
				}
				ctx.put("users", userRoleList);
				return getTemplate("users.html");
			}
			else if(userRole.getRole().getRid() == 2) {
				return getTemplate("home.html");
			}
			else {
				return getTemplate("home.html");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return getTemplate("invalidlogin.html");
		}
		
	}

	
}

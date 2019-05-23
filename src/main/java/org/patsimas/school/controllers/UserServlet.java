package org.patsimas.school.controllers;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.jdbc.UserDAOImpl;



@WebServlet("/users")
public class UserServlet extends VelocityViewServlet {

	@Override
	protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
		
		UserDAO ud = new UserDAOImpl();
		
		List<User> userList = null;
		
		try {
			userList = ud.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ctx.put("users", userList);
		
		return getTemplate("users.html");
	}

	
}

package org.patsimas.school.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.jdbc.UserDAOImpl;

@WebServlet("/authenticate")
public class LoginServlet extends VelocityViewServlet {

	@Override
	protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
		
		UserDAO ud = new UserDAOImpl();
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		try {
			User user = ud.getUser(username, password);
			
			session.setAttribute("user", user);
			
			ctx.put("user", user);
			
			return getTemplate("home.html");
		}
		catch(Exception ex) {
			
			return getTemplate("invalidlogin.html");
		}
		
	}

	
}

package org.patsimas.school.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.patsimas.school.model.entity.User;

@WebServlet("/help")
public class HelpServlet extends VelocityViewServlet {

	@Override
	protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		System.out.println(user);
		
		return getTemplate("exp.html");
	}

	
}

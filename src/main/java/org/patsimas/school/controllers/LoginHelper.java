package org.patsimas.school.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.patsimas.school.model.dao.UserDAO;
import org.patsimas.school.model.entity.User;

public class LoginHelper {

	 public static User getLoggedInDirectorFromCookie(HttpServletRequest req) throws Exception {        
	        HttpSession session = req.getSession();        
	        if (session == null) {
	            throw new Exception("Not authorized");
	        }
	        User user = (User)session.getAttribute("director");                
	        if (user == null) {
	            throw new Exception("Invalid session");
	        }
	        return user;        
	    }
}

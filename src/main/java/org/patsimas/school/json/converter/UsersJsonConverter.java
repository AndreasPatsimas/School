package org.patsimas.school.json.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.patsimas.school.clients.RestClient;
import org.patsimas.school.model.entity.User;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/conv")
public class UsersJsonConverter extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<User> userList = new ArrayList();
		
		RestClient rc = new RestClient();
		
		String data = rc.getData("http://localhost:8080/school/api/users");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			User[] u = mapper.readValue(data, User[].class);
			userList.addAll( Arrays.asList( u ));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(userList);
		resp.sendRedirect("index.jsp");
	}

	
}

package org.patsimas.school.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.patsimas.school.model.entity.Role;
import org.patsimas.school.model.entity.User;
import org.patsimas.school.model.entity.UserRole;

public class DatabaseHelper {

	private static final String URL = "jdbc:mysql://localhost:3306/school?serverTimezone=UCT";
	private static final String USER = "root";
	private static final String PASS = "@r!$!9!4";

	static {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}

	private static Connection openConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	static User fetchUserOrNull(String query, long id) {
		try {
			Connection con = openConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, id);
			return fetchUserOrNull(ps);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	static User fetchUserOrNull(String query, String username, String password) throws Exception {

		try {
			Connection con = openConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			return fetchUserOrNull(ps);
		} catch (SQLException e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	private static User createUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));

		return user;
	}

	private static User fetchUserOrNull(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return createUser(rs);
		} else {
			return null;
		}
	}

	//1
	static UserRole fetchUserRoleOrNull(String query, Long id, User user) throws Exception {
		try {
			Connection con = openConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, id);
			return fetchUserRoleOrNull(ps, user);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	//2
	private static UserRole fetchUserRoleOrNull(PreparedStatement ps, User user) throws Exception {
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return createUserRole(rs, user);
		} else {
			return null;
		}
	}
	
	//3
	private static UserRole createUserRole(ResultSet rs, User user) throws Exception {
		UserRole userRole = new UserRole();
		Long rid = rs.getLong("rid");
		Role role = Role.getRoleFor(rid);
		userRole.setRole(role);
		userRole.setUser(user);
		return userRole;
	}
	


	static List<User> fetchUsers(String query) throws Exception {
		try {
			Connection con = openConnection();
			PreparedStatement ps = con.prepareStatement(query);
			return fetchUsers(ps);
		} catch (SQLException e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	private static List<User> fetchUsers(PreparedStatement ps) throws SQLException {
		List<User> users = new ArrayList();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User u = createUser(rs);
			users.add(u);
		}
		return users;
	}

}

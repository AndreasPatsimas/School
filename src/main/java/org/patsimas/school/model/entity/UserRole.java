package org.patsimas.school.model.entity;

public class UserRole {
	
	private User user;
	
	private Role role;

	public UserRole() {
		
	}

	public UserRole(User user, Role role) {
		
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [user=" + user + ", role=" + role + "]";
	}
	
}

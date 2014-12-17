package net.news.user;

import java.sql.SQLException;

import net.news.db.Database;

public class User {
	private String userId;
	private String password;
	private String name;
	
	public User(String userId, String password, String name) {
		this.userId = userId;
		this.password = password;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public boolean matchPassword(String newPassword) {
		return this.password.equals(newPassword);
	}
	
	public static boolean login(String email, String password) throws UserNotFoundException, PasswordMismatchException {
		Database db = new Database();
		User user = null;
		try {
			user = db.findByUserId(email);
		} catch (SQLException e) {
		}
		
		if (user == null) {
			throw new UserNotFoundException();
		}
		
		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException();
		}
		
		return true;
	}
}

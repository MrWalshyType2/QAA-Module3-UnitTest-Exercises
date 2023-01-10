package com.qaa.module3.unit_testing_exercises.exercise2;

import java.util.HashMap;
import java.util.Map;

public class UserService {

	private Map<String, String> users;
	
	public UserService() {
		this.users = new HashMap<>();
	}
	
	public String register(String username, String password) {
		// username must not be null or empty
		if (username == null) throw new IllegalArgumentException("Username must not be null");
		String trimmedUsername = username.trim();
		if (trimmedUsername.isEmpty()) throw new IllegalArgumentException("Username must not be whitespace only");
		
		// password must not be null or empty
		if (password == null) throw new IllegalArgumentException("Password must not be null");
		String trimmedPassword = password.trim();
		if (trimmedPassword.isEmpty()) throw new IllegalArgumentException("Password must not be whitespace only");

		// username must be at least 4 characters
		if (trimmedUsername.length() < 4) throw new IllegalArgumentException("Username must contain at least 4 characters");
		
		// username must be unique
		if (users.get(trimmedUsername) != null) throw new IllegalArgumentException("Username already exists");
		
		// password must be at least 6 characters
		if (trimmedPassword.length() < 6) throw new IllegalArgumentException("Password must contain at least 6 characters");

		// password must contain at least 1 uppercase character
		if (!trimmedPassword.matches("[A-Z|a-z|1-9]*[A-Z]+[A-Z|a-z|1-9]*")) throw new IllegalArgumentException("Password must contain at least 1 uppercase character");
		
		// password must contain at least 1 lowercase character
		if (!trimmedPassword.matches("[A-Z|a-z|1-9]*[a-z]+[A-Z|a-z|1-9]*")) throw new IllegalArgumentException("Password must contain at least 1 lowercase character");
		
		// password must contain at least 1 number
		if (!trimmedPassword.matches("[A-Z|a-z|1-9]*[1-9]+[A-Z|a-z|1-9]*")) throw new IllegalArgumentException("Password must contain at least 1 number character");
		
		// add user to map
		users.put(trimmedUsername, trimmedPassword);
		
		return trimmedUsername;
	}

	public String login(String username, String password) {
		// username and password must not be null
		if (username == null || password == null) throw new IllegalArgumentException("Username and password must not be null");
		String trimmedUsername = username.trim();
		String trimmedPassword = password.trim();
		
		// username and password must not be empty
		if (trimmedUsername.isEmpty() || trimmedPassword.isEmpty()) throw new IllegalArgumentException("Username and password must not be empty");
		
		String savedPassword = users.get(trimmedPassword);
		if (savedPassword == null) throw new RuntimeException("Invalid username supplied");
		
		if (!trimmedPassword.equals(savedPassword)) throw new IllegalArgumentException("Invalid password supplied");
		
		return username;
	}
}

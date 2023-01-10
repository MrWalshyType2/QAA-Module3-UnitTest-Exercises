package com.qaa.module3.unit_testing_exercises.exercise3;

public class UserController {

	private UserRepository repository;
	
	public UserController(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	public User register(User user) {
		// User must not be null
		if (user == null) throw new IllegalArgumentException("User must not be null");
		
		String username = user.getUsername();
		String password = user.getPassword();
		
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
		if (repository.exists(trimmedUsername)) throw new IllegalArgumentException("Username already exists");
		
		// password must be at least 6 characters
		if (trimmedPassword.length() < 6) throw new IllegalArgumentException("Password must contain at least 6 characters");

		// password must contain at least 1 uppercase character
		if (!trimmedPassword.matches("[A-Z|a-z|1-9]*[A-Z]+[A-Z|a-z|1-9]*")) throw new IllegalArgumentException("Password must contain at least 1 uppercase character");
		
		// password must contain at least 1 lowercase character
		if (!trimmedPassword.matches("[A-Z|a-z|1-9]*[a-z]+[A-Z|a-z|1-9]*")) throw new IllegalArgumentException("Password must contain at least 1 lowercase character");
		
		// password must contain at least 1 number
		if (!trimmedPassword.matches("[A-Z|a-z|1-9]*[1-9]+[A-Z|a-z|1-9]*")) throw new IllegalArgumentException("Password must contain at least 1 number character");
		
		// add user to db
		return repository.register(user);
	}
	
	public User login(User user) {
		// User must not be null
		if (user == null) throw new IllegalArgumentException("User must not be null");
			
		String username = user.getUsername();
		String password = user.getPassword();
		
		// username and password must not be null
		if (username == null || password == null) throw new IllegalArgumentException("Username and password must not be null");
		
		// username and password must not be empty
		if (username.isEmpty() || password.isEmpty()) throw new IllegalArgumentException("Username and password must not be empty");
		
		return repository.login(user);
	}
}

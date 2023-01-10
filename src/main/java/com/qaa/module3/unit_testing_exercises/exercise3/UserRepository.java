package com.qaa.module3.unit_testing_exercises.exercise3;

public interface UserRepository {

	public boolean exists(String trimmedUsername);

	public User register(User user);

	public User login(User user);

}

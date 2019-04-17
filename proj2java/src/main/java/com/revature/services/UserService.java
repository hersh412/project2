package com.revature.services;

import com.revature.models.User;

import java.util.List;

public interface UserService {
	
	public User getUserByEmail(String email);
	public List<User> getAllUsers();
	public void removeUser(String email);
	public User changeUser(String email, User user);
	public User addUser(User user);

}

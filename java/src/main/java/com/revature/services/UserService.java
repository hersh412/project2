package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	
	public User getUserByEmail(String email);
	public List<User> getAllUsers();
	public void removeUser(String email);
	public User changeUser(String email, User user);
	public User addUser(User user);

}

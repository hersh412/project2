package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	public User getUser(int id);
	public User getUserByEmail(String email);
	public void saveUser(User user);
	public void updateUser(String email, User user);
	public void deleteUser(String email);
	public List<User> getAllUsers();
	

}

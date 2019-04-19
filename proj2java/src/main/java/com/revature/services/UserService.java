package com.revature.services;

import com.revature.models.User;

import java.util.List;

public interface UserService {

	User getUserByEmail(String email);

	List<User> getAllUsers();

	void removeUser(String email);

	User changeUser(String email, User user);

	User addUser(User user);

	User getUserByUserId(int id);

}

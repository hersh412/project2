package com.revature.controllers;

import com.revature.models.Auth;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService userService;
	private AuthService authService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{email}")
	public User getUserByEmail(@RequestBody User user, Auth auth) {
		return userService.getUserByEmail(user.getEmail());
	}

	@PostMapping(consumes = "application/json")
	public void makeUser(@RequestBody User user, Auth auth) {
		//add something about authorization here
		userService.addUser(user);
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

}
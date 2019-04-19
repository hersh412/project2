package com.revature.controllers;

import com.revature.models.Auth;
import com.revature.models.User;
import com.revature.services.AuthServiceImpl;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService userService;
	private AuthServiceImpl authServiceImpl;


	public UserController() {
		super();
		// TODO Auto-generated constructor stub
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

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	/*
	@PostMapping(value="/user/validate", consumes = "application/JSON")
	public User validate(@RequestBody User user, Auth auth) {
		User authUser = AuthServiceImpl.validateAuth(user);

		if (authUser != null) {
			sess.setAttribute("user", authUser);
			return authUser;

		}

		return null;

	}
	*/
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setAuthService(AuthServiceImpl authService) {
		this.authServiceImpl = authServiceImpl;
	}

}

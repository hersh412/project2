package com.revature.controllers;

import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Auth;
import com.revature.models.User;
import com.revature.services.AuthServiceImpl;
import com.revature.services.UserService;

@RestController("/user")
@CrossOrigin(origins="*")
public class UserController {

	private UserService userService;
	private AuthServiceImpl authServiceImpl;


	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{email}")
	public User getUserByEmail(@RequestBody User user, Auth auth) {
		return userService.getUserByEmail(user.getEmail());
	}
	
	@PostMapping(consumes = "application/json")
	public void makeUser(@RequestBody User user, Auth auth) {
		userService.addUser(user);
	}
	/*
	@PostMapping(value="/user/validate", consumes = "application/json")
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

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController("/user")
@CrossOrigin(origins="*")
public class UserController {

	private UserService userService;
	
	private AuthService authService;

	@GetMapping("user/")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@PostMapping(consumes = "application/json")
	public void makeUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PostMapping(value="/user/validate", consumes = "application/json")
	public User validate(@RequestBody User user, HttpSession sess) {
		User authUser = authService.validateUser(user);
		
		if (authUser != null) {
			sess.setAttribute("user", authUser);
			return authUser;
			
		}
		
		return null;
		
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
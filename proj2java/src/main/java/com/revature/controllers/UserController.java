package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController("/user")
@CrossOrigin(origins="*")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	private UserService userService;
	private AuthService authService;

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/user/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	@PostMapping(consumes = "application/json")
	public void makeUser(@RequestBody User user) {
		logger.info("** POST REQUEST: USER");
		logger.info(user);
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

}
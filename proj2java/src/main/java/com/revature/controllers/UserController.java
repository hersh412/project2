package com.revature.controllers;

import com.revature.models.Auth;
import com.revature.models.Policy;
import com.revature.models.User;
import com.revature.services.AuthServiceImpl;
import com.revature.services.PolicyService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController("/user")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService userService;
	private AuthServiceImpl authServiceImpl;
	private PolicyService policyService;
    private static final Logger log = Logger.getLogger("UserController");


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

    @PostMapping(value = "/user/{id}/policy")
	public ResponseEntity makePolicy(@RequestBody User user, @PathVariable int id) {
		//todo
        log.info("Getting Create Policy Request for User:" + id);
		Policy p = new Policy();
		p.setOwner(userService.getUserByUserId(id));
		int policyID = policyService.addPolicy(p);
		if (policyID != 0)
			return new ResponseEntity<String>(Integer.toString(policyID), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Error: Unable to generate policy", HttpStatus.EXPECTATION_FAILED);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setAuthService(AuthServiceImpl authService) {
		this.authServiceImpl = authServiceImpl;
	}

	@Autowired
	public void setPolicyService(PolicyService policyService) {
		this.policyService = policyService;
	}

}

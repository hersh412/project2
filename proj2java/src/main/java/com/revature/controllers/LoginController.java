package com.revature.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Auth;
import com.revature.models.User;
import com.revature.services.AuthServiceImpl;
import com.revature.services.UserServiceImpl;
import com.revature.utils.TokenFactoryUtil;


@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	private static Logger log = Logger.getLogger("LoginController");
	private UserServiceImpl us;
	private AuthServiceImpl as;
	private User matchingEmailUser;
	
	@PostMapping()
	public ResponseEntity<Object> loginGet(@RequestBody Auth in) {
		System.out.println(in);
		HttpHeaders responseHeaders = new HttpHeaders();
		if (in.getEmail() == null || in.getPassword() ==null) {
			log.log(Level.INFO, "FAILURE NULL Email OR PASSORD");
			return new ResponseEntity<Object>("Email feild null || password feild null", responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
		matchingEmailUser = us.getUserByEmail(in.getEmail());
		
		if (matchingEmailUser==null) {
			log.log(Level.WARNING, "Email does not exist");
			return new ResponseEntity<Object>(in.getEmail()+" is not an account in our system", responseHeaders, HttpStatus.BAD_REQUEST);
			
		}else if(matchingEmailUser.getPassword().equals(in.getPassword())){
			log.log(Level.INFO, "Sucsess user logged in --> "+matchingEmailUser.toString());
			in = as.createAuth(matchingEmailUser.getId(), matchingEmailUser.getUserconf(), in);
			responseHeaders.add("Authorization", "Bearer " +in.getKey() );
			log.log(Level.INFO,"about to add this as key = "+in.getKey());
			matchingEmailUser.setToken(in.getKey());
			ResponseEntity<Object> resp =  new ResponseEntity<Object>(matchingEmailUser, responseHeaders, HttpStatus.ACCEPTED);
			log.log(Level.INFO,"response = "+resp);
			return resp;
		}else {
			log.log(Level.INFO, "Unauthorized Acess ");
			log.log(Level.SEVERE, "User: " + matchingEmailUser.toString());
			log.log(Level.SEVERE, "Auth: " + in.toString());
			return new ResponseEntity<Object>("UNAUTHORIZED", responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	@Autowired
	public void setAuthService(AuthServiceImpl as) {
		this.as = as;
	}
	
	@Autowired
	public void setUserService(UserServiceImpl us) {
		this.us = us;
	}
	

}
package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.services.UserServiceImpl;

public class Driver {

	public static void main(String[] args) {
		UserServiceImpl us = new UserServiceImpl();
		
		User a = new User();
		a.setAddress1("47 West Vine St");
		a.setCity("Pittsburgh");
		a.setEmail("bob@msn.com");
		a.setfName("Bob");
		a.setGender(1);
		a.setlName("Miller");
		a.setPassword("secret");
		a.setState("PA");
		a.setUserconf(1);
		a.setZip("15222");
		
		System.out.println("test");
		us.addUser(a);
		
		
//		User b = us.getUserByEmail("test@aol.com");
		List<User> lu = new ArrayList<User>(us.getAllUsers());
		for (User u: lu) {
			System.out.println("***** " + u.toString());
		}

	}

}

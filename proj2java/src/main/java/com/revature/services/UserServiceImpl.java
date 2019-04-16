package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userdao;
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	public void setUserdao(UserDao userdao) {
		logger.info("setting userdao");
		this.userdao = userdao;
	}

	@Override
	public User getUserByEmail(String email) {
		User ret = null;
		logger.info("getUserBgyEmail_email: " + email);
		ret = userdao.getUserByEmail(email);
		return ret;
	}

	@Override
	public User authenticate(User u) {
		User ret = null;
		logger.info("Attempting login: " + u.getEmail());
		ret = userdao.getUserByEmail(u.getEmail());
		logger.info("dao Returned " + ret.toString());
		if (ret != null && !ret.getPassword().equals(u.getPassword())) {
			ret = null;
			logger.info("Invalid login");
		}
		return ret;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> ul = null;
		ul = new ArrayList<User>(userdao.getAllUsers());
		return ul;
	}

	@Override
	public void removeUser(String email) {
		userdao.deleteUser(email);
	}

	@Override
	public User changeUser(String email, User user) {
		if (userdao.getUserByEmail(email) != null) {
			userdao.updateUser(email, user);
		return user;
	} 
		return null;
	}

	@Override
	public User addUser(User user) {
		User ret = null;
		userdao.saveUser(user);
		return null;
	}
	
	public UserServiceImpl() {
	}

	public UserServiceImpl(UserDao userdao) {
		this.userdao = userdao;
	}

	
	
	

}

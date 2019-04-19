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

	private UserDao userDao;
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	public void setUserdao(UserDao userDao) {
		logger.info("setting userdao");
		this.userDao = userDao;
	}

	@Override
	public User getUserByUserId(int id) {
		User ret = null;
		logger.info("Getting user by id: " + id);
		ret = userDao.getUser(id);
		return ret;
	}

	@Override
	public User getUserByEmail(String email) {
		User ret = null;
		logger.info("getUserByEmail_email: " + email);
		ret = userDao.getUserByEmail(email);
		return ret;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> ul = null;
		ul = new ArrayList<User>(userDao.getAllUsers());
		return ul;
	}

	@Override
	public void removeUser(String email) {
		userDao.deleteUser(email);
	}

	@Override
	public User changeUser(String email, User user) {
		if (userDao.getUserByEmail(email) != null) {
			userDao.updateUser(email, user);
		return user;
	} 
		return null;
	}

	@Override
	public User addUser(User user) {
		User ret = null;
		userDao.saveUser(user);
		return null;
	}
	
	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	
	

}

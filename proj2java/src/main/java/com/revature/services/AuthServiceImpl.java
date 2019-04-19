package com.revature.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.AuthDao;
import com.revature.models.Auth;
import com.revature.models.User;
import com.revature.utils.TokenFactoryUtil;

@Service
public class AuthServiceImpl {

	private static final Logger log = Logger.getLogger("AuthService");

	private AuthDao authDao;
	
	
	public String validateAuth(String token) {
		
		return "Invalid";
	}
	
	public Auth createAuth(int userId,int userConf,Auth in) {
		Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
		in.setTimeStamp(ts);
		in.setKey(TokenFactoryUtil.getToken(userId));
		in.setAuthLevel(userConf);
		authDao.createAuth(in);
		log.log(Level.INFO, "auth persisted " + in.getKey());
		return in;
		
	}
	
	@Autowired
	public void setAuthDao(AuthDao authDao) {
		this.authDao = authDao;
	}
	
	public AuthServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AuthServiceImpl(AuthDao authDao) {
		super();
		this.authDao = authDao;
	}


	

	
}

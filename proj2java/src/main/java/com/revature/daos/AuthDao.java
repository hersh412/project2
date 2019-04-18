package com.revature.daos;

import com.revature.models.Auth;

public interface AuthDao {
	public void deleteExpiredAuth(String email);
	public void createAuth(Auth auth);
	public Auth getAuth(String key);
}

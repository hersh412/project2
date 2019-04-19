package com.revature.daos;

import com.revature.models.Auth;

public interface AuthDao {
    void deleteExpiredAuth(String email);

    void createAuth(Auth auth);

    Auth getAuth(String key);
}

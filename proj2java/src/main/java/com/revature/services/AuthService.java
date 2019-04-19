package com.revature.services;

import com.revature.models.User;

public interface AuthService {

    User validateUser(User user);

}

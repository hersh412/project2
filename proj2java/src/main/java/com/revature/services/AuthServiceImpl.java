package com.revature.services;

import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger log = Logger.getLogger("AuthService");

    private UserService userService;

    @Override
    public User validateUser(User user) {

        log.log(Level.INFO, "Attempted login: " + user);

        User validatedUser = userService.getUserByEmail(user.getEmail());

        log.log(Level.INFO, "Actual Credentials: " + validatedUser);

        if(validatedUser != null && validatedUser.getPassword().equals(user.getPassword())) {

            return validatedUser;

        }

        return null;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public AuthServiceImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AuthServiceImpl(UserService userService) {
        super();
        this.userService = userService;
    }

}

package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@RestController("/login")
@CrossOrigin(origins ="*")
public class LoginController {

    private UserService us;
    private static final Logger log = Logger.getLogger("LoginController");

    @PostMapping(value="/login", consumes = "application/json")
    public ResponseEntity login (@RequestBody User u, HttpSession sess) {
        ResponseEntity ret = null;
        log.info("Getting POST request login for " + u.getEmail() + " & " + u.getPassword());
        User user = us.authenticate(u);
        if (ret != null) {
            ret = new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            ret = new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ret;
    }

    @Autowired
    public void setUs(UserService us) {
        this.us = us;
    }
}

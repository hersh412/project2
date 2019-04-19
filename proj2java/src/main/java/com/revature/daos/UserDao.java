package com.revature.daos;

import com.revature.models.User;

import java.util.List;

public interface UserDao {

    User getUser(int id);

    User getUserByEmail(String email);

    void saveUser(User user);

    void updateUser(String email, User user);

    void deleteUser(String email);

    List<User> getAllUsers();


}

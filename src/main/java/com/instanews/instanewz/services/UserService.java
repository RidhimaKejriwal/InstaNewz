package com.instanews.instanewz.services;

import java.util.Optional;

import com.instanews.instanewz.entities.User;

public interface UserService {
    
    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    boolean isUserExist(String id);

    boolean isUserExistByEmail(String email);

    User getUserByEmail(String email);
}

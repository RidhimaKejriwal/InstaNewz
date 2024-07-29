package com.instanews.instanewz.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.instanews.instanewz.entities.User;
import com.instanews.instanewz.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User saveUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

    @Override
    public Optional<User> getUserById(String id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public Optional<User> updateUser(User user) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public boolean isUserExist(String id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'isUserExist'");
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        
        throw new UnsupportedOperationException("Unimplemented method 'isUserExistByEmail'");
    }

    @Override
    public User getUserByEmail(String email) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUserByEmail'");
    }
    
}

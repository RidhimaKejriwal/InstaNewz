package com.instanews.instanewz.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.instanews.instanewz.entities.User;
import com.instanews.instanewz.helpers.Helper;
import com.instanews.instanewz.services.UserService;

@ControllerAdvice
public class RootController {
     private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    
    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) 
    {
        if(authentication == null)
            return;
        System.out.println("Adding logged in user information to the model");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in: {}", username);
        // getting user
        User user = userService.getUserByEmail(username);
        System.out.println(user);
       
        // System.out.println(user.getName());
        model.addAttribute("user", user);
    }
}

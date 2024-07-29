package com.instanews.instanewz.helpers;

import org.springframework.security.core.Authentication;

public class Helper {
    public static String getEmailOfLoggedInUser(Authentication authentication) {
        // email id and password login
        System.out.println("getting data from local database"); 
        return authentication.getName();
    }
}

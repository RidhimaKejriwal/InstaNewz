package com.instanews.instanewz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/dashboard")
    private String dashboard() {
        return "user/dashboard";
    }
}

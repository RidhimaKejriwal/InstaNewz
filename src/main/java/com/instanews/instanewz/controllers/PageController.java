package com.instanews.instanewz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
    
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage()
    {
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage()
    {
        return "services";
    }

    @RequestMapping("/contact")
    public String contactPage()
    {
        return "contact";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

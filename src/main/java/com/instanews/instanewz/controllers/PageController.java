package com.instanews.instanewz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instanews.instanewz.entities.NewsResponse;
import com.instanews.instanewz.entities.User;
import com.instanews.instanewz.forms.UserForm;
import com.instanews.instanewz.helpers.Message;
import com.instanews.instanewz.helpers.MessageType;
import com.instanews.instanewz.services.NewsService;
import com.instanews.instanewz.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    private final NewsService newsService;

    public PageController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:home";
    }
    
    @RequestMapping("/home")
    public String home(Model model) {

        NewsResponse newsResponse = newsService.getTop3("general").block(); // For debugging
        if (newsResponse != null) {
            model.addAttribute("articles", newsResponse.getArticles());
        } else {
            model.addAttribute("error", "Error fetching news");
        }
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        UserForm UserForm = new UserForm();
        model.addAttribute("userForm", UserForm);
        return "register";
    }

    // processing url
    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
        
        // fetch form data
        System.out.println(userForm);

        // validate form data
        if(rBindingResult.hasErrors()) {
            return "register";
        }

        // save to database
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        User savedUser = userService.saveUser(user);
        System.out.println(savedUser);

        // message = "Registration successful"
        Message message = Message.builder().content("Registration Successful!!").type(MessageType.green).build();
        session.setAttribute("message", message);

        // redirect to page
        return "redirect:/register";
    }
}

package com.instanews.instanewz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.instanews.instanewz.entities.NewsResponse;
import com.instanews.instanewz.services.NewsService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final NewsService newsService;

    public UserController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping("/dashboard")
    private String dashboard(@RequestParam(value = "category", defaultValue = "general") String category, Model model) {

        model.addAttribute("selectedCategory", category); // Set the selected category
        NewsResponse newsResponse = newsService.getTopHeadlines(category).block(); // For debugging
        if (newsResponse != null) {
            model.addAttribute("articles", newsResponse.getArticles());
        } else {
            model.addAttribute("error", "Error fetching news");
        }
        return "user/dashboard";
    }
}

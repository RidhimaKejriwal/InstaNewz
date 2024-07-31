package com.instanews.instanewz.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.instanews.instanewz.entities.NewsResponse;
import com.instanews.instanewz.services.NewsService;

@Controller
public class NewsController {

    private final NewsService newsService;
    private final String defaultCategory;

    public NewsController(NewsService newsService, @Value("${newsapi.defaultCategory}") String defaultCategory) {
        this.newsService = newsService;
        this.defaultCategory = defaultCategory;
    }

    @GetMapping("/help")
    public String getTopHeadlines(Model model) {

        NewsResponse newsResponse = newsService.getTopHeadlines(defaultCategory).block(); // For debugging
        if (newsResponse != null) {
            model.addAttribute("articles", newsResponse.getArticles());
        } else {
            model.addAttribute("error", "Error fetching news");
        }

        return "help";
    }
}

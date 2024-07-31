package com.instanews.instanewz.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.instanews.instanewz.entities.NewsResponse;

import reactor.core.publisher.Mono;

@Service
public class NewsService {
    
    private final WebClient webClient;
    private final String apiKey;

    public NewsService(WebClient.Builder webClientBuilder, @Value("${newsapi.key}") String apiKey) {
        this.webClient = webClientBuilder.baseUrl("https://newsapi.org/v2").build();
        this.apiKey = apiKey;
    }

    public Mono<NewsResponse> getTopHeadlines(String category) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/top-headlines")
                        .queryParam("category", category)
                        .queryParam("country", "in") 
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(NewsResponse.class);
    }
}

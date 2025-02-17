package com.example.LibraryApp.googleBooks;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "googleBooksClient", url = "https://www.googleapis.com/books/v1")

public interface GoogleBooksClient {

    @GetMapping("/volumes?q={query}&key={apiKey}")
    GoogleBooksResponse searchBooks(@PathVariable("query") String query);
}

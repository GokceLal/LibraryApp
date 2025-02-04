package com.example.LibraryApp.controller;

import com.example.LibraryApp.dto.response.AuthorResponseDTO;
import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.LibraryApp.constants.RestApiUrls.AUTHOR;
import static com.example.LibraryApp.constants.RestApiUrls.GET_ALL_AUTHORS;

@RestController
@RequestMapping(AUTHOR)
public class AuthorController {

    @Autowired
      private AuthorService authorService;

    @GetMapping(GET_ALL_AUTHORS)
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorService.getAllAuthors().stream().map(AuthorResponseDTO::new).toList();
    }
}

package com.example.LibraryApp.service;

import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorByName(String authorNameSurName) {
        return authorRepository.findByAuthorNameSurname(authorNameSurName);
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }
}

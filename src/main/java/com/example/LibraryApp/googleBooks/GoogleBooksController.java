package com.example.LibraryApp.googleBooks;

import com.example.LibraryApp.dto.response.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.LibraryApp.constants.RestApiUrls.*;


@RestController
@RequestMapping(API_GOOGLE_BOOKS)
public class GoogleBooksController {

    @Autowired
    private GoogleBooksService googleBooksService;

    @GetMapping(SEARCH_GOOGLE_BOOKS)
    public List<BookResponseDTO> searchBooks(@RequestParam String query) {
        return googleBooksService.searchBooks(query).stream().map(BookResponseDTO::new).toList();
    }

    //Google Books'tan kitapları çekip veritabanına kaydet
    @PostMapping(SAVE_GOOGLE_BOOKS)
    public ResponseEntity<String> saveBooksFromGoogle(@RequestParam String query) {
        googleBooksService.saveBooksFromGoogle(query);
        return ResponseEntity.ok("Google Books'tan kitaplar kaydedildi!");
    }

    @GetMapping(ALL_PUBLISHERS)
    public List<String> allPublishers() {
        return googleBooksService.getAllPublishers();
    }

    @GetMapping(ALL_BOOKS)
    public ResponseEntity<List<String>> getAllBooks() {
        List<String> books = googleBooksService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping(ALL_AUTHORS)
    public ResponseEntity<List<String>> getAllAuthors() {
        List<String> authors = googleBooksService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping(GET_STARTING_WITH_A)
    public ResponseEntity<List<String>> getStartingWithA() {
        List<String> books = googleBooksService.getStartingWithA();
        return ResponseEntity.ok(books);
    }

    @GetMapping(GET_BOOK_AFTER_2023)
    public ResponseEntity<List<String>> getBookAfter2023() {
        List<String> books = googleBooksService.getBookAfter2023();
        return ResponseEntity.ok(books);
    }
}

package com.example.LibraryApp.googleBooks;

import com.example.LibraryApp.dto.response.BookResponseDTO;
import com.example.LibraryApp.dto.response.GoogleBookResponseDTO;
import com.example.LibraryApp.dto.response.PublisherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.LibraryApp.constants.RestApiUrls.API_GOOGLE_BOOKS;
import static com.example.LibraryApp.constants.RestApiUrls.SEARCH_GOOGLE_BOOKS;

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
    @PostMapping("/save")
    public ResponseEntity<String> saveBooksFromGoogle(@RequestParam String query) {
        googleBooksService.saveBooksFromGoogle(query);
        return ResponseEntity.ok("Google Books'tan kitaplar kaydedildi!");
    }

    @GetMapping("/allPublisher")
    public List<String> allPublishers() {
        return googleBooksService.allPublishers();
    }

    @GetMapping("/allBooks")
    public ResponseEntity<List<String>> getAllBooks() {
        List<String> books = googleBooksService.allBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/allAuthors")
    public ResponseEntity<List<String>> getAllAuthors() {
        List<String> authors = googleBooksService.allAuthors();
        return ResponseEntity.ok(authors);
    }


}

package com.example.LibraryApp.controller;

import com.example.LibraryApp.dto.request.BookCreateDTO;
import com.example.LibraryApp.dto.request.BookUpdateDTO;
import com.example.LibraryApp.dto.response.BookResponseDTO;
import com.example.LibraryApp.entity.Book;
import com.example.LibraryApp.googleBooks.GoogleBooksService;
import com.example.LibraryApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.LibraryApp.constants.RestApiUrls.*;

@RestController
@RequestMapping(BOOK)
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private  GoogleBooksService googleBooksService;

    // Read - Tüm kitapları getir
    @GetMapping (GET_ALL_BOOKS)
    public List<BookResponseDTO> getAllBooks() {
        return bookService.getAllBooks().stream().map(BookResponseDTO::new).toList();
    }

    @GetMapping(GET_STARTING_WITH_A)
    public List<BookResponseDTO> getStartingWithA() {
        return bookService.getStartingWithA().stream().map(BookResponseDTO::new).toList();
    }

    @GetMapping(GET_BOOK_AFTER_2023)
    public List<BookResponseDTO> getBookAfter2023() {
        return bookService.getBookAfter2023().stream().map(BookResponseDTO::new).toList();
    }

    // Create - Yeni kitap ekle
    @PostMapping(CREATE_BOOK)
    public void createBook(@RequestBody BookCreateDTO bookCreateDTO) {
        bookService.createBook(new Book(bookCreateDTO));
    }

    @PutMapping(UPDATE_BOOK)
    public void updateBook(@RequestBody BookUpdateDTO bookUpdateDTO) {
        bookService.updateBook(new Book(bookUpdateDTO));
    }

    // Delete - Kitap sil
    @DeleteMapping(DELETE_BOOK)
    public void deleteBook(@RequestBody Long id) {
        bookService.deleteBook(id);
    }
}

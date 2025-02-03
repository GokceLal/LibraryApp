package com.example.LibraryApp.service;

import com.example.LibraryApp.entity.Book;
import com.example.LibraryApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Başlık 'A' harfi ile başlayan kitapları getir
    public List<Book> getStartingWithA() {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().startsWith("A"))
                .toList();
    }

    // 2023'ten sonra basılan kitapları getir
    public List<Book> getBookAfter2023() {
        return bookRepository.findAllByYearOfPublicationAfter(2023);
    }

    // Kitap ekle
    public void createBook(Book book) {
        publisherService.savePublisher(book.getPublisher());
        authorService.saveAuthor(book.getAuthor());
        book.getPublisher().getBookList().add(book);
        book.getAuthor().getBookList().add(book);
        bookRepository.save(book);
    }

    // Kitap güncelleme
    public void updateBook(Book book) {
        var existingBook = bookRepository.findById(book.getBookID()).orElse(null);
        if (existingBook != null) {
            existingBook.update(book);
            bookRepository.save(existingBook);
        } else {
            var publisher = publisherService.getPublisherByName(book.getPublisher().getPublisherName());
            if (publisher.isPresent()) {
                book.setPublisher(publisher.get());
                publisher.get().getBookList().add(book);
                publisherService.savePublisher(publisher.get());
            } else {
                book.getPublisher().getBookList().add(book);
                publisherService.savePublisher(book.getPublisher());
            }

            var author = authorService.getAuthorByName(book.getAuthor().getAuthorNameSurname());
            if (author.isPresent()) {
                book.setAuthor(author.get());
                author.get().getBookList().add(book);
                authorService.saveAuthor(author.get());
            } else {
                book.getAuthor().getBookList().add(book);
                authorService.saveAuthor(book.getAuthor());
            }
        }
    }

    // Kitap sil
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}

package com.example.LibraryApp.entity;

import com.example.LibraryApp.dto.request.BookCreateDTO;
import com.example.LibraryApp.dto.request.BookUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;

    private String title;

    private double price;

    private String ISBN13;

    private int yearOfPublication;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId", referencedColumnName = "publisherId")
    private Publisher publisher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private Author author;

    public Book(BookCreateDTO bookCreateDTO) {
        this.title = bookCreateDTO.getTitle();
        this.price = bookCreateDTO.getPrice();
        this.ISBN13 = bookCreateDTO.getISBN13();
        this.yearOfPublication = bookCreateDTO.getYearOfPublication();
        this.publisher = new Publisher(bookCreateDTO.getPublisherName());
        this.author = new Author(bookCreateDTO.getAuthorNameSurName());
    }

    public Book(BookUpdateDTO bookUpdateDTO) {
        this.bookID = bookUpdateDTO.getBookID();
        this.title = bookUpdateDTO.getTitle();
        this.price = bookUpdateDTO.getPrice();
        this.ISBN13 = bookUpdateDTO.getISBN13();
        this.yearOfPublication = bookUpdateDTO.getYearOfPublication();
        this.publisher = new Publisher(bookUpdateDTO.getPublisherName());
        this.author = new Author(bookUpdateDTO.getAuthorNameSurName());
    }

    public void update(Book book) {
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.ISBN13 = book.getISBN13();
        this.yearOfPublication = book.getYearOfPublication();
        this.publisher = book.getPublisher();
        this.author = book.getAuthor();
    }
}

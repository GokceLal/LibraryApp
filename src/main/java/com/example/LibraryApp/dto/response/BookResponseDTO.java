package com.example.LibraryApp.dto.response;


import com.example.LibraryApp.entity.Book;
import lombok.Builder;
import lombok.Data;


@Data
public class BookResponseDTO {

    private Long bookId;

    private String title;

    private double price;

    private String ISBN13;

    private int yearOfPublication;

    private AuthorResponseDTO authorResponseDTO;

    public BookResponseDTO(Book book) {
        this.bookId = book.getBookID();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.ISBN13 = book.getISBN13();
        this.yearOfPublication = book.getYearOfPublication();
        this.authorResponseDTO = new AuthorResponseDTO(book.getAuthor());
    }

}



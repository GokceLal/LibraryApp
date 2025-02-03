package com.example.LibraryApp.dto.request;


import lombok.Data;


@Data
public class BookUpdateDTO {

    private Long bookID;

    private String title;

    private double price;

    private String ISBN13;

    private int yearOfPublication;

    private String publisherName;

    private String authorNameSurName;
}



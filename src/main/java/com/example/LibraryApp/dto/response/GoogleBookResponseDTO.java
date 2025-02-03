package com.example.LibraryApp.dto.response;


import com.example.LibraryApp.entity.Book;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GoogleBookResponseDTO {

    private String title;

    private double price;

    private String ISBN13;

    private String publisherName;

    private String authorNameSurName;

}



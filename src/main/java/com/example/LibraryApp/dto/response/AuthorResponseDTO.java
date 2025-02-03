package com.example.LibraryApp.dto.response;


import com.example.LibraryApp.entity.Author;
import lombok.Data;


@Data
public class AuthorResponseDTO {

    private Long authorId;

    private String authorNameSurName;

    public AuthorResponseDTO(Author author) {
        this.authorId = author.getAuthorId();
        this.authorNameSurName = author.getAuthorNameSurname();
    }

}



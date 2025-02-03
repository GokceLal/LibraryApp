package com.example.LibraryApp.dto.response;

import com.example.LibraryApp.entity.Publisher;
import lombok.*;

import java.util.List;


@Data
public class PublisherResponseDTO {

    private Long publisherId;

    private String publisherName;

    private List<BookResponseDTO> bookResponseDTOList;

    public PublisherResponseDTO(Publisher publisher) {
        this.publisherId = publisher.getPublisherId();
        this.publisherName = publisher.getPublisherName();
        this.bookResponseDTOList = publisher.getBookList().stream().map(BookResponseDTO::new).toList();
    }

}

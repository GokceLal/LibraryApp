package com.example.LibraryApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    private String publisherName;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList = new ArrayList<>();

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

}

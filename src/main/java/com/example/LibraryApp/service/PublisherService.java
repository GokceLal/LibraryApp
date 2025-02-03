package com.example.LibraryApp.service;

import com.example.LibraryApp.entity.Book;
import com.example.LibraryApp.entity.Publisher;
import com.example.LibraryApp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public List<Publisher> getTwoPublishers() {
        return publisherRepository.findAll().stream().limit(2).toList();
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Optional<Publisher> getPublisherByName(String publisherName) {
        return publisherRepository.findByPublisherName(publisherName);
    }
}

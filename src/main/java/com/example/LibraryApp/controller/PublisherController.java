package com.example.LibraryApp.controller;

import com.example.LibraryApp.dto.response.PublisherResponseDTO;
import com.example.LibraryApp.entity.Publisher;
import com.example.LibraryApp.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.LibraryApp.constants.RestApiUrls.*;

@RestController
@RequestMapping(PUBLISHER)
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(GET_ALL_PUBLISHERS)
    public List<PublisherResponseDTO> getAllPublishers() {
        return publisherService.getAllPublishers().stream().map(PublisherResponseDTO::new).toList();
    }


    @GetMapping(GET_TWO_PUBLISHERS)
    public List<PublisherResponseDTO> getTwoPublishers() {
        var publishers = publisherService.getTwoPublishers();
        return publishers.stream().map(PublisherResponseDTO::new).toList();
    }

}

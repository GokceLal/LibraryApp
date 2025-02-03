package com.example.LibraryApp.service;

import com.example.LibraryApp.entity.Publisher;
import com.example.LibraryApp.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestPublisherService {

    @InjectMocks
    private PublisherService publisherService;

    @Mock
    private PublisherRepository publisherRepository;

    @Test
    void getAllPublishers() {
        //given
        var publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setPublisherName("Publisher 1");
        when(publisherRepository.findAll()).thenReturn(List.of(publisher));

        //when
        var result = publisherService.getAllPublishers();

        //then
        verify(publisherRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals(publisher.getPublisherId(), result.getFirst().getPublisherId());
    }

    @Test
    void getTwoPublishers() {
        //given
        var publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setPublisherName("Publisher 1");
        var publisher2 = new Publisher();
        publisher2.setPublisherId(2L);
        publisher2.setPublisherName("Publisher 2");
        when(publisherRepository.findAll()).thenReturn(List.of(publisher, publisher2));

        //when
        var result = publisherService.getTwoPublishers();

        //then
        verify(publisherRepository, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals(publisher.getPublisherId(), result.getFirst().getPublisherId());
    }

}

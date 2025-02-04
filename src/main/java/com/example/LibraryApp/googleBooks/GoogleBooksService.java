package com.example.LibraryApp.googleBooks;

import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.entity.Book;
import com.example.LibraryApp.entity.Publisher;
import com.example.LibraryApp.repository.AuthorRepository;
import com.example.LibraryApp.repository.BookRepository;
import com.example.LibraryApp.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoogleBooksService {

    private final GoogleBooksClient googleBooksClient;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    // Aramaya göre kitapta , yazarda ve yayıneviye göre geçen kelimenin kitaplarını aratma
    public List<Book> searchBooks(String query) {
        GoogleBooksResponse response = googleBooksClient.searchBooks(query);
        return response.getItems().stream()
                .filter(item -> item.getVolumeInfo().getAuthors() != null && item.getVolumeInfo().getPublisher() != null)
                .map(this::convertToBook)
                .toList();
    }

    // DTO'ya dönüştürme işlemi
    private Book convertToBook(GoogleBooksResponse.Item item) {
        GoogleBooksResponse.VolumeInfo info = item.getVolumeInfo();
        String isbn = info.getIndustryIdentifiers() != null && !info.getIndustryIdentifiers().isEmpty()
                ? info.getIndustryIdentifiers().get(0).getIdentifier()
                : "N/A";

        return new Book(null, info.getTitle(), 1431.8, isbn, 2023, new Publisher(info.getPublisher() != null ? info.getPublisher() : "Unknown"), new Author(info.getAuthors() != null ? info.getAuthors().stream().collect(Collectors.joining(", ")) : "Unknown"));
    }

    public void saveBooksFromGoogle(String query) {
        bookRepository.saveAll(searchBooks(query));
    }

    //Tüm yayınevlerini listele
    public List<String> getAllPublishers() {
        GoogleBooksResponse response = googleBooksClient.searchBooks("subject:books");

        if (response == null || response.getItems() == null) {
            return List.of();
        }

        Set<String> publisherNames = new HashSet<>();
        response.getItems().forEach(item -> {
            String publisherName = item.getVolumeInfo().getPublisher();
            if (publisherName != null && !publisherName.isEmpty()) {
                publisherNames.add(publisherName);
            }
        });

        return publisherNames.stream().toList();

    }

    //Tüm kitapları listele
    public List<String> getAllBooks() {
        GoogleBooksResponse response = googleBooksClient.searchBooks("subject:books");

        if (response == null || response.getItems() == null) {
            return List.of();
        }

        return response.getItems().stream()
                .map(item -> item.getVolumeInfo().getTitle()) // Sadece kitap adını al
                .filter(title -> title != null && !title.isEmpty()) // Boş veya null başlıkları filtrele
                .toList();
    }

    // Tüm yazarları listele
    public List<String> getAllAuthors() {
        GoogleBooksResponse response = googleBooksClient.searchBooks("subject:books");

        if (response == null || response.getItems() == null) {
            return List.of();
        }

        return response.getItems().stream()
                .map(item -> item.getVolumeInfo().getAuthors())
                .filter(authors -> authors != null && !authors.isEmpty())
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    // A harfi ile başlayan kitapları listele
    public List<String> getStartingWithA() {
        GoogleBooksResponse response = googleBooksClient.searchBooks("subject:books");

        if (response == null || response.getItems() == null) {
            return List.of();
        }

        return response.getItems().stream()
                .map(item -> item.getVolumeInfo().getTitle()) // Sadece kitap adını al
                .filter(title -> title != null && !title.isEmpty()) // Boş veya null başlıkları filtrele
                .filter(title -> title.startsWith("A")) // A harfi ile başlayan kitapları filtrele
                .toList();
    }

    // 2023'ten sonra basılan kitapları listele
    public List<String> getBookAfter2023() {
        GoogleBooksResponse response = googleBooksClient.searchBooks("subject:books");

        if (response == null || response.getItems() == null) {
            return List.of();
        }

        return response.getItems().stream()
                .map(item -> item.getVolumeInfo().getTitle()) // Sadece kitap adını al
                .filter(title -> title != null && !title.isEmpty()) // Boş veya null başlıkları filtrele
                .filter(title -> title.startsWith("A")) // A harfi ile başlayan kitapları filtrele
                .toList();

    }
}

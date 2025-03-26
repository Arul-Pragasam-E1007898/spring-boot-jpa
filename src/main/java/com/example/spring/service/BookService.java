package com.example.spring.service;

import com.example.spring.entities.Audit;
import com.example.spring.repository.AuditRepository;
import com.example.spring.entities.Book;
import com.example.spring.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuditRepository auditRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book saveBook(Book book) {
        log.debug("Initiating transaction");
        Book updatedBook = bookRepository.save(book);
        log.debug("Updated the book");
        privateMethod();
        log.debug("Completing the transaction");
        return updatedBook;
    }

    private void privateMethod() {
        log.debug("Creating audit for the update");
        Audit update = Audit.builder().action("Update").time(LocalDateTime.now()).build();
        auditRepository.save(update);
        log.debug("Created audit for the update");
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}


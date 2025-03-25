package com.example.spring.controllers;

import com.example.spring.entities.Audit;
import com.example.spring.entities.AuditRepository;
import com.example.spring.entities.Book;
import com.example.spring.entities.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
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
        Book updatedBook = bookRepository.save(book);
        privateMethod();
        throw new RuntimeException("Err");
    }

    private void privateMethod() {
        Audit update = Audit.builder().action("Update").time(LocalDateTime.now()).build();
        auditRepository.save(update);
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}


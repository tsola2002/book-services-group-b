package com.example.mofe.bookservice.service;

import com.example.mofe.bookservice.model.Book;
import com.example.mofe.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get a single book by ID
    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + bookId));
    }

    // Create a new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Integer bookId, Book bookDetails) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + bookId));

        book.setName(bookDetails.getName());
        book.setWeight(bookDetails.getWeight());

        return bookRepository.save(book);
    }

    // Delete a book by ID
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}

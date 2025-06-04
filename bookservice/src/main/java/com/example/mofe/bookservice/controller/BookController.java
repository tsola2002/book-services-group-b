package com.example.mofe.bookservice.controller;

import com.example.mofe.bookservice.model.Book;
import com.example.mofe.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://book-store-iota-woad.vercel.app"
})
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") Integer bookId) {
        return service.getBookById(bookId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") Integer bookId, @RequestBody Book bookDetails) {
        return service.updateBook(bookId, bookDetails);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId) {
        service.deleteBook(bookId);
    }
}

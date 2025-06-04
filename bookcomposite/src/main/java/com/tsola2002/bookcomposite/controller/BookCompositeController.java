package com.tsola2002.bookcomposite.controller;

import com.tsola2002.bookcomposite.entity.BookComposite;
import com.tsola2002.bookcomposite.service.BookCompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookcomposite")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://book-store-iota-woad.vercel.app"
})
public class BookCompositeController {

    @Autowired
    private BookCompositeService bookCompositeService;

    @GetMapping
    public List<BookComposite> getAllBookComposites() {
        return bookCompositeService.getAllBookComposites();
    }

    @GetMapping("/{bookId}")
    public BookComposite getBookComposite(@PathVariable int bookId) {
        return bookCompositeService.getBookComposite(bookId);
    }
}

package com.tsola2002.bookcomposite.controller;

import com.tsola2002.bookcomposite.entity.BookComposite;
import com.tsola2002.bookcomposite.service.BookCompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bookcomposite")
public class BookCompositeController {

    @Autowired
    private BookCompositeService bookCompositeService;

    @GetMapping("/{bookId}")
    public BookComposite getBookComposite(@PathVariable int bookId) {
        return bookCompositeService.getBookComposite(bookId);
    }
}

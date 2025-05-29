package com.tsola2002.bookcomposite.service;

import com.tsola2002.bookcomposite.entity.BookComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class BookCompositeService {

    @Autowired
    private RestTemplate restTemplate;

    public BookComposite getBookComposite(int bookId) {
//        String bookUrl = "http://localhost:8084/api/v1/books/" + bookId;
        String reviewUrl = "https://reviewservice-to9o.onrender.com/api/v1/reviews/" + bookId;
        String recommendationUrl = "https://recommendationservice-rlr1.onrender.com/api/v1/recommendations/" + bookId;

//        Map<String, Object> book = restTemplate.getForObject(bookUrl, Map.class);
        List<Map<String, Object>> review = restTemplate.getForObject(reviewUrl, List.class);
        List<Map<String, Object>> recommendation = restTemplate.getForObject(recommendationUrl, List.class);

//        BookComposite composite = new BookComposite(book, review, recommendation);
        BookComposite composite = new BookComposite(review, recommendation);

        return composite;
    }
}
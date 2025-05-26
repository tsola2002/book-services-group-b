package com.tsola2002.bookcomposite.service;

import com.tsola2002.bookcomposite.entity.BookComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class BookCompositeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public BookComposite getBookComposite(int bookId) {
//        String bookUrl = "http://localhost:8081/api/v1/books/" + bookId;
//        String reviewUrl = "http://localhost:8083/api/v1/ratings/" + bookId;
        String recommendationUrl = "http://localhost:8086/api/v1/recommendations/" + bookId;

//        Map<String, Object> book = restTemplate.getForObject(bookUrl, Map.class);
//        List<Map<String, Object>> review = restTemplate.getForObject(reviewUrl, List.class);
        List<Map<String, Object>> recommendation = restTemplate.getForObject(recommendationUrl, List.class);

//        BookComposite composite = new BookComposite(book, review, recommendation);
        BookComposite composite = new BookComposite(null, recommendation);

        // Save to MongoDB
        mongoTemplate.save(composite);

        return composite;
    }
}
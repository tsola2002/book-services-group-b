package com.tsola2002.recommendationservice.controller;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    // Get all recommendations for a specific book
    @GetMapping("/{bookId}")
    public List<Recommendation> getRecommendationsByBookId(@PathVariable int bookId) {
        return recommendationService.getByBookId(bookId);
    }

    // Create a new recommendation
    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationService.save(recommendation);
    }

    // Update a recommendation by ID
    @PutMapping("/{id}")
    public Recommendation updateRecommendation(@PathVariable Long id, @RequestBody Recommendation recommendationDetails){
        return recommendationService.updateRecommendation(id, recommendationDetails);
    }

    // Delete all recommendations for a specific book
    @DeleteMapping("/{bookId}")
    public void deleteRecommendationsByBookId(@PathVariable int bookId) {
        recommendationService.deleteByBookId(bookId);
    }
}

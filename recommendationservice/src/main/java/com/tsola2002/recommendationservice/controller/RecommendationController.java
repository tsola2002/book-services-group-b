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

    // Get all recommendations
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    // Get all recommendations for a specific book
    @GetMapping("/{bookId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Recommendation> getRecommendationsByBookId(@PathVariable int bookId) {
        return recommendationService.getByBookId(bookId);
    }

    // Create a new recommendation
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationService.save(recommendation);
    }

    // Update a recommendation by ID
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Recommendation updateRecommendation(@PathVariable Long id, @RequestBody Recommendation recommendationDetails){
        return recommendationService.updateRecommendation(id, recommendationDetails);
    }

    // Delete all recommendations for a specific book
    @DeleteMapping("/{bookId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteRecommendationsByBookId(@PathVariable int bookId) {
        recommendationService.deleteByBookId(bookId);
    }
}

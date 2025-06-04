package com.tsola2002.recommendationservice.controller;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recommendations")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://book-store-iota-woad.vercel.app"
})
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/")
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    @GetMapping("/{bookId}")
    public List<Recommendation> getRecommendationsByBookId(@PathVariable Long bookId) {
        return recommendationService.getRecommendationsByBookId(bookId);
    }

    // ✅ New endpoint to get recommendation by ID
    @GetMapping("recommendation/{recommendationId}")
    public Recommendation getRecommendationById(@PathVariable Long recommendationId) {
        return recommendationService.getRecommendationById(recommendationId);
    }

    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationService.saveRecommendation(recommendation);
    }

    @PutMapping("/{recommendationId}")
    public Recommendation updateRecommendation(@PathVariable Long recommendationId,
                                               @RequestBody Recommendation recommendationDetails) {
        return recommendationService.updateRecommendation(recommendationId, recommendationDetails);
    }

    @DeleteMapping("/{recommendationId}")
    public void deleteRecommendation(@PathVariable Long recommendationId) {
        recommendationService.deleteRecommendation(recommendationId);
    }
}

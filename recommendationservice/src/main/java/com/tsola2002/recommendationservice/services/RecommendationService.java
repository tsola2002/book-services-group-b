package com.tsola2002.recommendationservice.services;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    // Get all recommendations
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    // Get all recommendations for a specific book
    public List<Recommendation> getByBookId(int bookId) {
        return recommendationRepository.findAllByBookId(bookId);
    }

    // Create a new recommendation
    public Recommendation save(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    // Update an existing recommendation
    public Recommendation updateRecommendation(Long id, Recommendation recommendationDetails) {
        return recommendationRepository.findById(id).map(recommendation -> {
            recommendation.setBookId(recommendationDetails.getBookId());
            recommendation.setRecommendationId(recommendationDetails.getRecommendationId());
            recommendation.setAuthor(recommendationDetails.getAuthor());
            recommendation.setRate(recommendationDetails.getRate());
            recommendation.setContent(recommendationDetails.getContent());
            return recommendationRepository.save(recommendation);
        }).orElseThrow(() -> new RuntimeException("Recommendation not found with id " + id));
    }

    // Delete all recommendations by book ID
    public void deleteByBookId(int bookId) {
        List<Recommendation> recommendations = recommendationRepository.findAllByBookId(bookId);
        recommendationRepository.deleteAll(recommendations);
    }
}

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

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    public List<Recommendation> getRecommendationsByBookId(Long bookId) {
        return recommendationRepository.findAllByBookId(bookId);
    }

    public Recommendation getRecommendationById(Long recommendationId) {
        return recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new RuntimeException("Recommendation not found with ID " + recommendationId));
    }

    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public Recommendation updateRecommendation(Long recommendationId, Recommendation updatedDetails) {
        Recommendation existingRecommendation = recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new RuntimeException("Recommendation not found with ID " + recommendationId));

        existingRecommendation.setAuthor(updatedDetails.getAuthor());
        existingRecommendation.setRate(updatedDetails.getRate());
        existingRecommendation.setContent(updatedDetails.getContent());

        return recommendationRepository.save(existingRecommendation);
    }

    public void deleteRecommendation(Long recommendationId) {
        if (!recommendationRepository.existsById(recommendationId)) {
            throw new RuntimeException("Recommendation not found with ID " + recommendationId);
        }
        recommendationRepository.deleteById(recommendationId);
    }
}

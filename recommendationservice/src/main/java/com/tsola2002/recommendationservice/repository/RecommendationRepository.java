package com.tsola2002.recommendationservice.repository;

import com.tsola2002.recommendationservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    // Retrieve all recommendations by a specific book ID
    List<Recommendation> findAllByBookId(int bookId);
}

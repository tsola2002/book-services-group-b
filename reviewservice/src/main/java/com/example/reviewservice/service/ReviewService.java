package com.example.reviewservice.service;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get all reviews for a specific book
    public List<Review> getReviewsByBookId(int bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    // Create a new review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // ✅ Get review by reviewId
    public Review getReviewById(String reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + reviewId));
    }

    // ✅ Update a review by reviewId
    public Review updateReviewById(String reviewId, Review reviewDetails) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + reviewId));

        review.setAuthor(reviewDetails.getAuthor());
        review.setSubject(reviewDetails.getSubject());
        review.setContent(reviewDetails.getContent());

        return reviewRepository.save(review);
    }

    // ✅ Delete a review by reviewId
    public void deleteReviewById(String reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + reviewId));

        reviewRepository.delete(review);
    }
}

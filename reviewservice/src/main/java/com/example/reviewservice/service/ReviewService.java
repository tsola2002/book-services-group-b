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
    public List<Review> getReviewsByBookId(String bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    // Create a new review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Update an existing review by ID
    public Review updateReview(String id, Review reviewDetails) {
        return reviewRepository.findById(id).map(review -> {
            review.setBookId(reviewDetails.getBookId());
            review.setAuthor(reviewDetails.getAuthor());
            review.setSubject(reviewDetails.getSubject());
            review.setContent(reviewDetails.getContent());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found with id " + id));
    }

    // Delete all reviews for a specific book
    public void deleteReviewsByBookId(String bookId) {
        List<Review> reviews = reviewRepository.findByBookId(bookId);
        reviewRepository.deleteAll(reviews);
    }

    // Delete a single review by ID
    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }
}

package com.example.reviewservice.controller;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://book-store-iota-woad.vercel.app"
})
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable int bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    // ✅ Get a single review by reviewId
    @GetMapping("/review/{reviewId}")
    public Review getReviewById(@PathVariable String reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // ✅ Update a review by reviewId
    @PutMapping("/{reviewId}")
    public Review updateReviewById(@PathVariable String reviewId, @RequestBody Review review) {
        return reviewService.updateReviewById(reviewId, review);
    }

    // ✅ Delete a review by reviewId
    @DeleteMapping("/{reviewId}")
    public void deleteReviewById(@PathVariable String reviewId) {
        reviewService.deleteReviewById(reviewId);
    }
}

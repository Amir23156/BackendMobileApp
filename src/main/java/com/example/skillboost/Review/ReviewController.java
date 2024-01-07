package com.example.skillboost.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/getReviewsForProduct/{productId}")
    public ResponseEntity<List<Review>> getReviewsForProduct(@PathVariable String productId) {
        List<Review> reviews = reviewService.getReviewsByProduct(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(reviewService.addReview(review), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllReviews")
    public ResponseEntity<List<Review>> findAllReviews() {
        return new ResponseEntity<>(reviewService.findAllReviews(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findReviewById/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable String reviewId) {
        Review review = reviewService.findReviewById(reviewId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            String errorMessage = "Review with ID '" + reviewId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/deleteReview/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable String reviewId) {
        reviewService.deleteReviewById(reviewId);
        return new ResponseEntity<>("Review with ID " + reviewId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateReview/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable String reviewId, @RequestBody Review updatedReview) {
        Review existingReview = reviewService.findReviewById(reviewId);
        if (existingReview != null) {
            // Update necessary fields using setters
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());

            Review savedReview = reviewService.addReview(existingReview);
            return new ResponseEntity<>(savedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


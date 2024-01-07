package com.example.skillboost.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByProduct(String productId) {
        // Assuming you have a method in the repository to find reviews by product
        return reviewRepository.findByProductId(productId);
    }

    public Review findReviewById(String reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public void deleteReviewById(String reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        reviewOptional.ifPresent(reviewRepository::delete);
        // Additional logic if needed
    }

    public Review updateReview(String reviewId, Review updatedReview) {
        Optional<Review> existingReviewOptional = reviewRepository.findById(reviewId);
        if (existingReviewOptional.isPresent()) {
            Review existingReview = existingReviewOptional.get();
            // Update necessary fields using setters
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());

            return reviewRepository.save(existingReview);
        } else {
            // Handle the case when the review with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}



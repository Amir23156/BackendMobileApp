package com.example.skillboost.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    // Find reviews by product ID
    List<Review> findByProductId(String productId);

    // Find a review by its ID
    java.util.Optional<Review> findById(String reviewId);

    // Find a review by its comment (assuming comments are unique)
    Review findByComment(String comment);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Review> findByRatingGreaterThanEqual(int rating);
}


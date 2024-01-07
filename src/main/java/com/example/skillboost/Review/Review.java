package com.example.skillboost.Review;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {
    @Id
    private String id; // Changed from reviewID to id

    private int rating;
    private String comment;
    private String productId; // Added productId

    // Constructors
    public Review(int rating, String comment, String productId) {
        this.rating = rating;
        this.comment = comment;
        this.productId = productId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Method to submit a review
    public void submitReview() {
        // Implement the logic for submitting a review
        System.out.println("Review submitted successfully!");
        System.out.println("Review ID: " + id);
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + comment);
        System.out.println("Product ID: " + productId);
    }

    public static void main(String[] args) {
        // Example usage
        Review userReview = new Review(5, "Great product!", "12345");
        userReview.submitReview();
    }
}

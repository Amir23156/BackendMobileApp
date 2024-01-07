package com.example.skillboost.Progress;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "progress")
public class Progress {
    @Id
    private String id;

    private int completedLessons;
    private int totalLessons;

    // Constructors
    public Progress(int completedLessons, int totalLessons) {
        this.completedLessons = completedLessons;
        this.totalLessons = totalLessons;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(int completedLessons) {
        this.completedLessons = completedLessons;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public void setTotalLessons(int totalLessons) {
        this.totalLessons = totalLessons;
    }

    // Method to track progress
    public void trackProgress() {
        // Implement the logic for tracking progress
        System.out.println("Progress tracked successfully!");
        System.out.println("Progress ID: " + id);
        System.out.println("Completed Lessons: " + completedLessons);
        System.out.println("Total Lessons: " + totalLessons);
    }

    public static void main(String[] args) {
        // Example usage
        Progress userProgress = new Progress(10, 20);
        userProgress.trackProgress();
    }
}

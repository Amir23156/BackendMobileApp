package com.example.skillboost.Progress;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressRepository extends MongoRepository<Progress, String> {

    // Find progress by its ID
    java.util.Optional<Progress> findById(String progressId);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Progress> findByCompletedLessonsGreaterThanEqual(int completedLessons);
}


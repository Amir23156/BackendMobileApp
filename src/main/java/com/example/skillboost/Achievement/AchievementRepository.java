package com.example.skillboost.Achievement;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AchievementRepository extends MongoRepository<Achievement, String> {

    // Find an achievement by ID
    Optional<Achievement> findById(String achievementId);

    // Find an achievement by name (assuming names are unique)
    Achievement findByAchievementName(String achievementName);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Achievement> findBySomeProperty(String propertyValue);
}


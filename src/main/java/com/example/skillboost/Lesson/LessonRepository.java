package com.example.skillboost.Lesson;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LessonRepository extends MongoRepository<Lesson, String> {

    // Find a lesson by ID
    Optional<Lesson> findById(String lessonId);

    // Find a lesson by title (assuming titles are unique)
    Lesson findByLessonTitle(String lessonTitle);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Lesson> findBySomeProperty(String propertyValue);
}

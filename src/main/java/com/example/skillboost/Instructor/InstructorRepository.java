package com.example.skillboost.Instructor;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InstructorRepository extends MongoRepository<Instructor, String> {

    // Find an instructor by ID
    Optional<Instructor> findById(String instructorId);

    // Find an instructor by name (assuming names are unique)
    Instructor findByInstructorName(String instructorName);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Instructor> findBySomeProperty(String propertyValue);
}

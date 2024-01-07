package com.example.skillboost.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Integer> {

    // Find a student by ID
    Optional<Student> findById(int studentId);

    // Find a student by name (assuming names are unique)
    // Optional<Student> findByStudentName(String studentName);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Student> findBySomeProperty(String propertyValue);
}


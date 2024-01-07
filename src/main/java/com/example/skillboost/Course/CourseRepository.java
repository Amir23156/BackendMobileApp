package com.example.skillboost.Course;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Course> findByInstructors(Instructor instructor);
}

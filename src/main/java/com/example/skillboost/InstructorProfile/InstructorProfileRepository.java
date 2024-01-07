package com.example.skillboost.InstructorProfile;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorProfileRepository extends MongoRepository<InstructorProfile, String> {

    // Find an instructor profile by its ID
    java.util.Optional<InstructorProfile> findById(String instructorProfileId);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<InstructorProfile> findByTotalEarningsGreaterThanEqual(double totalEarnings);
}

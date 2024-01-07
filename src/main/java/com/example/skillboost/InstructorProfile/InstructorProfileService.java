package com.example.skillboost.InstructorProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorProfileService {

    @Autowired
    private InstructorProfileRepository instructorProfileRepository;

    public InstructorProfile addInstructorProfile(InstructorProfile instructorProfile) {
        return instructorProfileRepository.save(instructorProfile);
    }

    public List<InstructorProfile> findAllInstructorProfiles() {
        return instructorProfileRepository.findAll();
    }

    public InstructorProfile findInstructorProfileById(String instructorProfileId) {
        return instructorProfileRepository.findById(instructorProfileId).orElse(null);
    }

    public void deleteInstructorProfileById(String instructorProfileId) {
        Optional<InstructorProfile> instructorProfileOptional = instructorProfileRepository.findById(instructorProfileId);
        instructorProfileOptional.ifPresent(instructorProfileRepository::delete);
        // Additional logic if needed
    }

    public InstructorProfile updateInstructorProfile(String instructorProfileId, InstructorProfile updatedInstructorProfile) {
        Optional<InstructorProfile> existingInstructorProfileOptional = instructorProfileRepository.findById(instructorProfileId);
        if (existingInstructorProfileOptional.isPresent()) {
            InstructorProfile existingInstructorProfile = existingInstructorProfileOptional.get();
            // Update necessary fields using setters
            existingInstructorProfile.setCoursesTaught(updatedInstructorProfile.getCoursesTaught());
            existingInstructorProfile.setTotalEarnings(updatedInstructorProfile.getTotalEarnings());
            existingInstructorProfile.setPendingEarnings(updatedInstructorProfile.getPendingEarnings());

            return instructorProfileRepository.save(existingInstructorProfile);
        } else {
            // Handle the case when the instructor profile with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}


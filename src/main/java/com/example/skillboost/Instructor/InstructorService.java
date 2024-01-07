package com.example.skillboost.Instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(String instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

    public void deleteInstructorById(String instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        instructorOptional.ifPresent(instructorRepository::delete);
        // Additional logic if needed
    }

    public Instructor updateInstructor(String instructorId, Instructor updatedInstructor) {
        Optional<Instructor> existingInstructorOptional = instructorRepository.findById(instructorId);
        if (existingInstructorOptional.isPresent()) {
            Instructor existingInstructor = existingInstructorOptional.get();
            // Update necessary fields using setters
            existingInstructor.setInstructorName(updatedInstructor.getInstructorName());

            return instructorRepository.save(existingInstructor);
        } else {
            // Handle the case when the instructor with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}


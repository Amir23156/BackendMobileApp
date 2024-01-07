package com.example.skillboost.Instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/getAllInstructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/getInstructorById/{instructorId}")
    public ResponseEntity<?> getInstructorById(@PathVariable String instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        if (instructor != null) {
            return ResponseEntity.ok(instructor);
        } else {
            String errorMessage = "Instructor with ID '" + instructorId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping("/addInstructor")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(instructorService.addInstructor(instructor), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateInstructor/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String instructorId, @RequestBody Instructor updatedInstructor) {
        Instructor existingInstructor = instructorService.getInstructorById(instructorId);
        if (existingInstructor != null) {
            // Update necessary fields using setters
            existingInstructor.setInstructorName(updatedInstructor.getInstructorName());

            Instructor savedInstructor = instructorService.addInstructor(existingInstructor);
            return new ResponseEntity<>(savedInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteInstructor/{instructorId}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable String instructorId) {
        instructorService.deleteInstructorById(instructorId);
        return new ResponseEntity<>("Instructor with ID " + instructorId + " deleted", HttpStatus.OK);
    }
}


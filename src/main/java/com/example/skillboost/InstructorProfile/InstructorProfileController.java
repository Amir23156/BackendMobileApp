package com.example.skillboost.InstructorProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructorProfiles")
public class InstructorProfileController {

    @Autowired
    private InstructorProfileService instructorProfileService;

    @PostMapping("/addInstructorProfile")
    public ResponseEntity<InstructorProfile> addInstructorProfile(@RequestBody InstructorProfile instructorProfile) {
        return new ResponseEntity<>(instructorProfileService.addInstructorProfile(instructorProfile), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllInstructorProfiles")
    public ResponseEntity<List<InstructorProfile>> findAllInstructorProfiles() {
        return new ResponseEntity<>(instructorProfileService.findAllInstructorProfiles(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findInstructorProfileById/{instructorProfileId}")
    public ResponseEntity<?> findInstructorProfileById(@PathVariable String instructorProfileId) {
        InstructorProfile instructorProfile = instructorProfileService.findInstructorProfileById(instructorProfileId);
        if (instructorProfile != null) {
            return ResponseEntity.ok(instructorProfile);
        } else {
            String errorMessage = "Instructor Profile with ID '" + instructorProfileId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/deleteInstructorProfile/{instructorProfileId}")
    public ResponseEntity<String> deleteInstructorProfileById(@PathVariable String instructorProfileId) {
        instructorProfileService.deleteInstructorProfileById(instructorProfileId);
        return new ResponseEntity<>("Instructor Profile with ID " + instructorProfileId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateInstructorProfile/{instructorProfileId}")
    public ResponseEntity<InstructorProfile> updateInstructorProfile(@PathVariable String instructorProfileId,
                                                                    @RequestBody InstructorProfile updatedInstructorProfile) {
        InstructorProfile existingInstructorProfile = instructorProfileService.findInstructorProfileById(instructorProfileId);
        if (existingInstructorProfile != null) {
            // Update necessary fields using setters
            existingInstructorProfile.setCoursesTaught(updatedInstructorProfile.getCoursesTaught());
            existingInstructorProfile.setTotalEarnings(updatedInstructorProfile.getTotalEarnings());
            existingInstructorProfile.setPendingEarnings(updatedInstructorProfile.getPendingEarnings());

            InstructorProfile savedInstructorProfile = instructorProfileService.addInstructorProfile(existingInstructorProfile);
            return new ResponseEntity<>(savedInstructorProfile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


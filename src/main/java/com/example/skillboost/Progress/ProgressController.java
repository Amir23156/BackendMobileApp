package com.example.skillboost.Progress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/getProgressById/{progressId}")
    public ResponseEntity<?> getProgressById(@PathVariable String progressId) {
        Progress progress = progressService.getProgressById(progressId);
        if (progress != null) {
            return ResponseEntity.ok(progress);
        } else {
            String errorMessage = "Progress with ID '" + progressId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping("/trackProgress")
    public ResponseEntity<Progress> trackProgress(@RequestBody Progress progress) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(progressService.trackProgress(progress), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllProgress")
    public ResponseEntity<List<Progress>> findAllProgress() {
        return new ResponseEntity<>(progressService.findAllProgress(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteProgress/{progressId}")
    public ResponseEntity<String> deleteProgressById(@PathVariable String progressId) {
        progressService.deleteProgressById(progressId);
        return new ResponseEntity<>("Progress with ID " + progressId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateProgress/{progressId}")
    public ResponseEntity<Progress> updateProgress(@PathVariable String progressId, @RequestBody Progress updatedProgress) {
        Progress existingProgress = progressService.getProgressById(progressId);
        if (existingProgress != null) {
            // Update necessary fields using setters
            existingProgress.setCompletedLessons(updatedProgress.getCompletedLessons());
            existingProgress.setTotalLessons(updatedProgress.getTotalLessons());

            Progress savedProgress = progressService.trackProgress(existingProgress);
            return new ResponseEntity<>(savedProgress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

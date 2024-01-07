package com.example.skillboost.Lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/getLessonById/{lessonId}")
    public ResponseEntity<?> getLessonById(@PathVariable String lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        if (lesson != null) {
            return ResponseEntity.ok(lesson);
        } else {
            String errorMessage = "Lesson with ID '" + lessonId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping("/addLesson")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(lessonService.addLesson(lesson), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllLessons")
    public ResponseEntity<List<Lesson>> findAllLessons() {
        return new ResponseEntity<>(lessonService.findAllLessons(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteLesson/{lessonId}")
    public ResponseEntity<String> deleteLessonById(@PathVariable String lessonId) {
        lessonService.deleteLessonById(lessonId);
        return new ResponseEntity<>("Lesson with ID " + lessonId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateLesson/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable String lessonId, @RequestBody Lesson updatedLesson) {
        Lesson existingLesson = lessonService.getLessonById(lessonId);
        if (existingLesson != null) {
            // Update necessary fields using setters
            existingLesson.setLessonTitle(updatedLesson.getLessonTitle());
            existingLesson.setLessonContent(updatedLesson.getLessonContent());

            Lesson savedLesson = lessonService.addLesson(existingLesson);
            return new ResponseEntity<>(savedLesson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


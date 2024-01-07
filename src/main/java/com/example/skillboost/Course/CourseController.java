package com.example.skillboost.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findCourseById/{courseId}")
    public ResponseEntity<?> findCourseById(@PathVariable String courseId) {
        Course course = courseService.findCourseById(courseId);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            String errorMessage = "Course with ID '" + courseId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable String courseId) {
        courseService.deleteCourseById(courseId);
        return new ResponseEntity<>("Course with ID " + courseId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateCourse/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable String courseId, @RequestBody Course updatedCourse) {
        Course existingCourse = courseService.findCourseById(courseId);
        if (existingCourse != null) {
            // Update necessary fields using setters
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setInstructors(updatedCourse.getInstructors());

            Course savedCourse = courseService.addCourse(existingCourse);
            return new ResponseEntity<>(savedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

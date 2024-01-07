package com.example.skillboost.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course findCourseById(String courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public void deleteCourseById(String courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        courseOptional.ifPresent(courseRepository::delete);
        // Additional logic if needed
    }

    public Course updateCourse(String courseId, Course updatedCourse) {
        Optional<Course> existingCourseOptional = courseRepository.findById(courseId);
        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            // Update necessary fields using setters
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setInstructors(updatedCourse.getInstructors());

            return courseRepository.save(existingCourse);
        } else {
            // Handle the case when the course with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}

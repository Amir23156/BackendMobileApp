package com.example.skillboost.Course;

import com.example.skillboost.Instructor.Instructor;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Course {
    @Id
    private String id;

    private String courseId;
    private String courseName;
    private List<Instructor> instructors;

    // Constructors
    public Course() {
    }

    public Course(String courseId, String courseName, List<Instructor> instructors) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructors = instructors;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    // Additional methods or logic as needed
}

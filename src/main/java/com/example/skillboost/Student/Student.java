package com.example.skillboost.Student;

import com.example.skillboost.Achievement.Achievement;
import com.example.skillboost.Course.Course;
import com.example.skillboost.Progress.Progress;

import java.util.List;
import java.util.Map;

public class Student {

    private int studentId;
    private List<Course> enrolledCourses;
    private List<Course> completedCourses;
    private Map<Course, Progress> progressTracker;
    private List<Achievement> achievements;

    // Constructors
    public Student() {
        // Default constructor
    }

    public Student(int studentId, List<Course> enrolledCourses, List<Course> completedCourses,
                   Map<Course, Progress> progressTracker, List<Achievement> achievements) {
        this.studentId = studentId;
        this.enrolledCourses = enrolledCourses;
        this.completedCourses = completedCourses;
        this.progressTracker = progressTracker;
        this.achievements = achievements;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public List<Course> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(List<Course> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public Map<Course, Progress> getProgressTracker() {
        return progressTracker;
    }

    public void setProgressTracker(Map<Course, Progress> progressTracker) {
        this.progressTracker = progressTracker;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
}


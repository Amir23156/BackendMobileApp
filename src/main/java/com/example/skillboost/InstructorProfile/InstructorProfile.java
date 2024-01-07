package com.example.skillboost.InstructorProfile;

import com.example.skillboost.Instructor.Instructor;
import com.example.skillboost.Course.Course;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "instructorProfiles")
public class InstructorProfile {

    @Id
    private String id;

    private Instructor instructor;
    private List<Course> coursesTaught;
    private double totalEarnings;
    private double pendingEarnings;

    // Constructors
    public InstructorProfile(Instructor instructor, List<Course> coursesTaught, double totalEarnings, double pendingEarnings) {
        this.instructor = instructor;
        this.coursesTaught = coursesTaught;
        this.totalEarnings = totalEarnings;
        this.pendingEarnings = pendingEarnings;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public double getPendingEarnings() {
        return pendingEarnings;
    }

    public void setPendingEarnings(double pendingEarnings) {
        this.pendingEarnings = pendingEarnings;
    }

    // Method to display instructor profile information
    public void displayProfile() {
        System.out.println("Instructor Profile:");
        System.out.println("ID: " + id);
        System.out.println("Instructor: " + instructor.getInstructorName());
        System.out.println("Courses Taught: " + coursesTaught);
        System.out.println("Total Earnings: $" + totalEarnings);
        System.out.println("Pending Earnings: $" + pendingEarnings);
    }

    public static void main(String[] args) {
        // Example usage
        Instructor instructor = new Instructor("1", "John Doe");
        Course course1 = new Course("1", "Java Programming", List.of(instructor));
        Course course2 = new Course("2", "Spring Boot Basics", List.of(instructor));

        InstructorProfile instructorProfile = new InstructorProfile(instructor, List.of(course1, course2), 5000.0, 1000.0);
        instructorProfile.displayProfile();
    }
}

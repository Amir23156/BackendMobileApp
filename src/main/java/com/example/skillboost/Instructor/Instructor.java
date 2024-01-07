package com.example.skillboost.Instructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")
public class Instructor {
    @Id
    private String instructorId;
    private String instructorName;

    // Constructors
    public Instructor() {
        // Default constructor
    }

    public Instructor(String instructorId, String instructorName) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
    }

    // Getters and Setters
    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    // Method to display instructor information
    public void displayInstructorInfo() {
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Instructor Name: " + instructorName);
    }

    public static void main(String[] args) {
        // Example usage
        Instructor instructor = new Instructor("001", "John Doe");
        instructor.displayInstructorInfo();
    }
}


package com.example.skillboost.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public void deleteStudentById(int studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        studentOptional.ifPresent(studentRepository::delete);
        // Additional logic if needed
    }

    public Student updateStudent(int studentId, Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(studentId);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            // Update necessary fields using setters
            existingStudent.setEnrolledCourses(updatedStudent.getEnrolledCourses());
            existingStudent.setCompletedCourses(updatedStudent.getCompletedCourses());
            existingStudent.setProgressTracker(updatedStudent.getProgressTracker());
            existingStudent.setAchievements(updatedStudent.getAchievements());

            return studentRepository.save(existingStudent);
        } else {
            // Handle the case when the student with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}

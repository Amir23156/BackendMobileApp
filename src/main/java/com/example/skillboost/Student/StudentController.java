package com.example.skillboost.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentById/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable int studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            String errorMessage = "Student with ID '" + studentId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllStudents")
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student with ID " + studentId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student updatedStudent) {
        Student existingStudent = studentService.findStudentById(studentId);
        if (existingStudent != null) {
            // Update necessary fields using setters
            existingStudent.setEnrolledCourses(updatedStudent.getEnrolledCourses());
            existingStudent.setCompletedCourses(updatedStudent.getCompletedCourses());
            existingStudent.setProgressTracker(updatedStudent.getProgressTracker());
            existingStudent.setAchievements(updatedStudent.getAchievements());

            Student savedStudent = studentService.addStudent(existingStudent);
            return new ResponseEntity<>(savedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

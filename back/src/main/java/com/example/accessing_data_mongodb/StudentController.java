package com.example.accessing_data_mongodb;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

/**
 * Controller class that handles HTTP requests related to Student entities.
 */
@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * Handles GET requests to retrieve all students.
     *
     * @return List of all students retrieved from the database.
     */
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Handles POST requests to add a new student.
     *
     * @param student The student object to be added, received in the request body.
     * @return ResponseEntity indicating success or failure of the operation.
     */
    @PostMapping("/addNewStudents")
    public ResponseEntity<String> addNewStudents(@RequestBody Student student) {
        try {
            studentService.addNewStudent(student.getFirstName(), student.getLastName(), student.getProgram(), student.getMail(), student.getBirthdate());
            return ResponseEntity.ok("Student created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while creating the student.");
        }
    }
}

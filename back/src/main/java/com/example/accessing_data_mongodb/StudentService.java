package com.example.accessing_data_mongodb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class that handles business logic related to Student entities.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    /**
     * Adds a new student to the database.
     *
     * @param firstName The first name of the student.
     * @param lastName  The last name of the student.
     * @param program   The program in which the student is enrolled.
     * @param mail      The email address of the student.
     * @param birthdate The birthdate of the student.
     * @return The student object added to the database.
     */
    public Student addNewStudent(String firstName, String lastName, String program, String mail, LocalDate birthdate) {
        Student student = new Student(firstName, lastName, program, mail, birthdate);
        return studentRepository.save(student);
    }
    /**
     * Retrieves all students from the database.
     *
     * @return A list of all students stored in the database.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

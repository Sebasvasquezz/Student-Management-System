package com.example.accessing_data_mongodb;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a Student entity in the application.
 */
@Document("Student")
public class Student {

  @Id
  public String id;
  public String firstName;
  public String lastName;
  public String program;
  public String mail;
  public LocalDate birthdate;

  /**
   * Constructs a new Student object with the given details.
   *
   * @param firstName The first name of the student.
   * @param lastName  The last name of the student.
   * @param program   The program in which the student is enrolled.
   * @param mail      The email address of the student.
   * @param birthdate The birthdate of the student.
   */
  public Student(String firstName, String lastName, String program, String mail, LocalDate birthdate) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.program = program;
    this.mail = mail;
    this.birthdate = birthdate;
  }

  /**
     * Returns a string representation of the Student object.
     *
     * @return A string representation containing the student's details.
     */
  @Override
  public String toString() {
    return String.format(
        "Student[id=%s, firstName='%s', lastName='%s', program='%s', mail='%s', birthdate='%s']",
        id, firstName, lastName,program, mail, birthdate);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public LocalDate  getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate  birthdate) {
    this.birthdate = birthdate;
  }

}
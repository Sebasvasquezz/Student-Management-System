package com.example.accessing_data_mongodb;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Main application class for managing student data using MongoDB.
 */
@SpringBootApplication
@EnableMongoRepositories
public class StudentsTableApplication implements CommandLineRunner {

  @Autowired
  private StudentRepository repository;

   /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application.
     */
  public static void main(String[] args) {
    SpringApplication.run(StudentsTableApplication.class, args);
  }
  
   /**
     * Method called after the Spring Boot application has started.
     * Inserts initial data into the MongoDB database.
     *
     * @param args Command-line arguments passed to the application.
     * @throws Exception If an exception occurs during data insertion.
     */
  @Override
  public void run(String... args) throws Exception {
    // Clear existing data
    repository.deleteAll();
    // Insert initial data
    System.out.println("Start data insertion...");
    repository.save(new Student("Juan Sebastian", "Vasquez Vega", "sistemas", "juan.vasquez-v@mail.escuelaing.edu.co", LocalDate.of(2000, 6, 11)));
    repository.save(new Student("Jose Ricardo", "Vasquez Vega", "civil", "jose.vasquez-v@mail.escuelaing.edu.co", LocalDate.of(1998, 11, 17)));
    System.out.println("End data insertion...");
  }
}



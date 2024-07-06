package com.example.accessing_data_mongodb;


import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * Repository interface for managing Student entities in MongoDB.
 * Extends MongoRepository which provides basic CRUD operations.
 */
public interface StudentRepository extends MongoRepository<Student, String> {

}
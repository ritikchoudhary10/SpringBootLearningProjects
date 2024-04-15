package com.ritik.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ritik.documents.Student;

public interface StudentMongoRepository extends MongoRepository<Student, String> {

}

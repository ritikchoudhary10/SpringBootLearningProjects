package com.ritik.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ritik.entity.Student;

public interface IStudentRepo extends CrudRepository<Student, Long> {

}

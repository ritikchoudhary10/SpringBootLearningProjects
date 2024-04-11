package com.ritik.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ritik.entity.Student;

public interface PagingAndSortingRepo extends PagingAndSortingRepository<Student, Long>,CrudRepository<Student,Long>{
}

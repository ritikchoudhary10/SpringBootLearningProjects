package com.ritik.service;

import com.ritik.entity.Student;

public interface IStudentService {
	
   public Iterable<Student> getSortedRecords(Boolean flag,String... columnNames);
   
   public Iterable<Student> getPage(Integer pageNo, Integer pageSize);
}

package com.ritik.service;

import com.ritik.entity.Student;

public interface IStudentService {

	public String addStudent(Student student);
	public Iterable<Student> getAllStudentsDetails();
	public Long studentCount();
	public String addStudents(Iterable<Student> allStd);
	public String isStudentAvailable(Long id);
}

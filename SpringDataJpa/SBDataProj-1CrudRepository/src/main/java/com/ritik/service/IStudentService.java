package com.ritik.service;

import com.ritik.entity.Student;

public interface IStudentService {

	public String addStudent(Student student);
	public Iterable<Student> getAllStudentsDetails();
	public Long studentCount();
	public Student  getStudentDetails(Long id);
	public String addStudents(Iterable<Student> allStd);
	public String isStudentAvailable(Long id);
	public String deleteAllStudentsData();
	public String deleteAllByStudentData(Iterable<Student> list);
	public String deleteAllStudentsByIds(Iterable<Long> ids);
	public String delete(Student std);
	public String deleteById(Long id);
	public Iterable<Student> findAllByStudentIds(Iterable<Long> ids);
	public String updateStdAdrr(Long id , String adrr);
	public Student getStudentDetailsOrDummyData(Long id);
	
}

package com.ritik.service;

import java.util.List;

import com.ritik.documents.Student;

public interface IStudentService {

	public String insertStudent(Student std);
	public List<String> insertAllStudent(Iterable<Student> list);
	public String saveStudent(Student std);
	public List<String> saveAllStudent(Iterable<Student> list);
	public Student getStudentInfo(String id);
	public Iterable<Student> getStudentInfiByIds(Iterable<String> ids);
	public String deleteAll(Iterable<String> ids);
	
	// paging and sorting
	
	public List<Student> getStudentsInfo(boolean flag,String... properties);
	public List<Student> getPage(int pageNo,boolean flag , String... properties);
	
}

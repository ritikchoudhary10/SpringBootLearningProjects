package com.ritik.service;

import com.ritik.entity.Student;

public interface IStudentService {

	public String addStudent(Student student);
	public Iterable<Student> getAllStudentsDetails();
	public Long studentCount();
	public String addStudents(Iterable<Student> allStd);
	public String isStudentAvailable(Long id);
	public String getStudentDetails(Long id);
	public String getStudentDetailsOrDummyData(Long id);
	public String updateStdAdrr(Long id,String addr);
	public void findAllByStudentIds(Iterable<Long> ids);
	public String deleteById(Long id);
	public String delete(Student std);
	public String deleteAllStudentsByIds(Iterable<Long> ids);
	public String deleteAllByStudentData(Iterable<Student> stds);
	public String deleteAllStudentsData();
}

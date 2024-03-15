package com.ritik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.Repository.IStudentRepo;
import com.ritik.entity.Student;
@Service
public class IstudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo repo;
	
	@Override
	public String addStudent(Student student) {
		Student student2 = repo.save(student);
		return "Student data save and generated StudentId is "+student2.getStdId();
	}

	@Override
	public Iterable<Student> getAllStudentsDetails() {
		return repo.findAll();
		
	}

	@Override
	public Long studentCount() {
		return repo.count();
	}

	@Override
	public String addStudents(Iterable<Student> allStd) {
		Iterable<Student> saveAll = repo.saveAll(allStd);
		StringBuilder saveMsg=new StringBuilder();
		saveAll.forEach((std)->{saveMsg.append(std.getStdId()+"->");
								saveMsg.append(std.getStdname()+"\n");
		});
		return saveMsg.toString();
	}
	
	@Override
	public String isStudentAvailable(Long id) {
		return repo.existsById(id)?"Student available with id "+id:"Student not available with id "+id;
	}

}

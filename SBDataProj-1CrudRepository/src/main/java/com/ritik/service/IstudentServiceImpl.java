package com.ritik.service;

import java.util.Optional;

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
		saveAll.forEach((std)->{saveMsg.append(std.getStdname()+" registered with id "+"->");
		saveMsg.append(std.getStdId()+"\n");
		});
		return saveMsg.toString();
	}
	
	@Override
	public String isStudentAvailable(Long id) {
		return repo.existsById(id)?"Student available with id "+id:"Student not available with id "+id;
	}

	@Override
	public String getStudentDetails(Long id) {
		Student std = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Student Not Available with id "+id));
		return std.toString() ;
	}
	@Override
	public String getStudentDetailsOrDummyData(Long id) {
	Student std = new Student(0L,"No record",11111111111L,"no record");
		Optional<Student> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get().toString();
		
		return std.toString();
	}
	
	@Override
	public String updateStdAdrr(Long id, String addr) {
		Optional<Student> opt = repo.findById(id);
		if(opt.isPresent()) {
			Student student = opt.get();
			student.setStdAdrr(addr);
			repo.save(student);
			return "Address updated successfully of student id "+id;
		}
		return "Record not available with id "+id;
	}
	
	@Override
	public void findAllByStudentIds(Iterable<Long> ids) {
		Iterable<Student> allById = repo.findAllById(ids);
		System.out.println("==========================================================================================");
		allById.forEach(System.out::println);
		System.out.println("==========================================================================================");
	}
	
	@Override
	public String deleteById(Long id) {
		repo.deleteById(id);
		return "Student Record with id-"+id+" deleted";
	}
	
	@Override
	public String delete(Student std) {
		repo.delete(std);
		return "Student record with id-"+std.getStdId()+" is deleted";
	}
	
	@Override
	public String deleteAllStudentsByIds(Iterable<Long> ids) {
		
		repo.deleteAllById(ids);
		return "record deleted with ids "+ids.toString();
	}
	
	@Override
	public String deleteAllByStudentData(Iterable<Student> stds) {
		repo.deleteAll(stds);
		StringBuilder sb =new StringBuilder();
		stds.forEach((std)->{sb.append(std.getStdId()+"\n");});
		return "Student records are deleted with ids "+sb;
		
	}
	
	@Override
	public String deleteAllStudentsData() {
		repo.deleteAll();
		return "All Students records deleted Successfully";
	}
}

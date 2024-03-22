package com.ritik.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.Repository.IStudentRepo;
import com.ritik.customexception.StudentNotFoundException;
import com.ritik.entity.Student;

@Service
public class IstudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo repo;

	@Override
	public String addStudent(Student student) {
		Student student2 = repo.save(student);
		return "Student data save and generated StudentId is " + student2.getStdId();
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
		StringBuilder saveMsg = new StringBuilder();
		saveAll.forEach((std) -> {
			saveMsg.append(std.getStdId() + "->");
			saveMsg.append(std.getStdname() + "\n");
		});
		return saveMsg.toString();
	}

	@Override
	public String isStudentAvailable(Long id	) {
		return repo.existsById(id) ? "Student available with id " + id : "Student not available with id " + id;
	}

	@Override
	public String delete(Student std) {
		repo.delete(std);
		return "Student deleted with id "+ std.getStdId();
	}

	@Override
	public String deleteAllByStudentData(Iterable<Student> list) {
		repo.deleteAll(list);
		StringBuilder ids =new StringBuilder();
		list.forEach((std)->{
			ids.append(std.getStdId()+" ,");
		});
		ids.delete(ids.lastIndexOf(","), ids.length());
		return "students deleted with ids "+ids.toString();
	}

	@Override
	public String deleteAllStudentsByIds(Iterable<Long> ids) {
		repo.deleteAllById(ids);
		return "students record deleted with ids "+ids;
	}

	@Override
	public String deleteAllStudentsData() {
		repo.deleteAll();
		return "All student details deleted";
	}

	@Override
	public String deleteById(Long id) {
		Optional<Student> byId = repo.findById(id);
		if(byId.isPresent()) {
			repo.deleteById(id);
			return "Student record deleted with id "+id;
		}
		return "record not available with id "+id;
	}

	@Override
	public Iterable<Student> findAllByStudentIds(Iterable<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public Student getStudentDetails(Long id) {
		return repo.findById(id).orElseThrow(()->new StudentNotFoundException("Student with id "+ id +"not found"));
	}

	@Override
	public Student getStudentDetailsOrDummyData(Long id) {
		Student dummy =new Student(00L, "Not Found", 000000000000L, "Not Found");
		Optional<Student> byId = repo.findById(id);
		if(byId.isPresent())
			return byId.get();
		return dummy;
	}

	@Override
	public String updateStdAdrr(Long id, String adrr) {
		Optional<Student> byId = repo.findById(id);
		if(byId.isPresent()) {
			Student std =byId.get();
			std.setStdAdrr(adrr);
			repo.save(std);
			return "address updated Successfully of Student with id "+id;
		}
		return "Record with id "+id +" not found";
	}

}

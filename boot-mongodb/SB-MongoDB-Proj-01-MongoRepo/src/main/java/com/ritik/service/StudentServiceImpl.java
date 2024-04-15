package com.ritik.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ritik.documents.Student;
import com.ritik.repository.StudentMongoRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMongoRepository repo;

	@Override
	public String insertStudent(Student std) {
		String id = repo.insert(std).getId();
		return id;
	}

	@Override
	public List<String> insertAllStudent(Iterable<Student> list) {
		List<String> ids = new ArrayList<String>();
		repo.insert(list).forEach((std) -> ids.add(std.getId()));
		return ids;
	}

	@Override
	public String saveStudent(Student std) {
		String id = repo.save(std).getId();
		return id;
	}

	@Override
	public List<String> saveAllStudent(Iterable<Student> list) {
		List<String> ids = new ArrayList<String>();
		repo.saveAll(list).forEach((std) -> ids.add(std.getId()));
		return ids;
	}

	@Override
	public Student getStudentInfo(String id) {
		Optional<Student> byId = repo.findById(id);
		if (byId.isPresent())
			return byId.get();
		throw new IllegalArgumentException("Student Info not found");
	}

	@Override
	public Iterable<Student> getStudentInfiByIds(Iterable<String> ids) {
		return repo.findAllById(ids);

	}

	@Override
	public String deleteAll(Iterable<String> ids) {
		repo.deleteAllById(ids);
		return "Record with all given ids are deleted";
	}

	@Override
	public List<Student> getStudentsInfo(boolean flag,String... properties) {
		Sort sort = Sort.by(flag?Direction.ASC:Direction.DESC, properties);
		return repo.findAll(sort);
	}

	@Override
	public List<Student> getPage(int pageNo , boolean flag ,String... properties) {
		Sort sort  = Sort.by(flag?Direction.ASC:Direction.DESC , properties);
		Pageable page = PageRequest.of(pageNo-1,2, sort);
		Page<Student> all = repo.findAll(page);
		if(all.getTotalPages()<=pageNo)
			throw new IllegalArgumentException("Requested page doesnot exist");
		return all.getContent();
	}

}

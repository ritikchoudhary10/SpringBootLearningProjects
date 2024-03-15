package com.ritik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ritik.entity.Student;
import com.ritik.repository.PagingAndSortingRepo;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	PagingAndSortingRepo repo;
	
	@Override
	public Iterable<Student> getSortedRecords(Boolean flag, String... columnNames) {
		Sort sort= Sort.by(flag?Direction.ASC:Direction.DESC, columnNames);
		return repo.findAll(sort);
	}

	@Override
	public Iterable<Student> getPage( Integer pageNo, Integer pageSize) {
Pageable p= PageRequest.of(pageNo-1,pageSize);
		Page<Student> all = repo.findAll(p);
		return all.getContent();
	}
}

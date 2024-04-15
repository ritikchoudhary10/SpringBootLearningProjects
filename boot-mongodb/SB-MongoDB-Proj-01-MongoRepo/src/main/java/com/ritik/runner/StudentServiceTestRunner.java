package com.ritik.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.documents.Student;
import com.ritik.service.IStudentService;

@Component
public class StudentServiceTestRunner implements CommandLineRunner {

	@Autowired
	private IStudentService ser;
	
	@Override
	public void run(String... args) throws Exception {
//	 	save service call	
//		Student std = new Student("Ritik Choudhary", 23, 29015, 12, 'A');
//		System.out.println("generated id -> "+ser.saveStudent(std));
		
//	 	insert service call
//		Student std= new Student(null, 5.10, 81.0, "Raju Rastogi", 22, 22456, 12, 'A');
//		System.out.println("generated id -> "+ser.insertStudent(std));
		
//		bulk insertion  using saveall and insert method
//		Student std1= new Student(null, 5.10, 81.0, "Ramu Seth", 22, 22456, 11, 'B');
//		Student std2= new Student(null, 5.10, 81.0, "Rajesh Bhanu", 16, 22459, 10, 'B');
//		Student std3 = new Student("Tejpal Singh", 20, 29011, 10, 'B');
//		Student std4 = new Student("Shubh Raut", 21, 29011, 12, 'A');
		
//		List<Student> stdDetails = List.of(std1,std2,std3,std4);
//		inserting through insert method of repo
//		ser.insertAllStudent(stdDetails).forEach(System.out::println);
		
//		bulk deletion after insertion using ids
//		List<String> ids=List.of("661caa3a851b22170f92526d","661caa3a851b22170f92526e","661caa3a851b22170f92526f","661caa3a851b22170f925270","661ca9923aa1a14aeb19bf4c","661ca9923aa1a14aeb19bf4b","661ca9923aa1a14aeb19bf4a","661ca9923aa1a14aeb19bf49");
//		System.out.println(ser.deleteAll(ids));
		
//		bulk insertion  using saveAll and saveAll method
//		Student std1= new Student(null, 5.10, 81.0, "Ramu Seth", 22, 22456, 11, 'B');
//		Student std2= new Student(null, 5.10, 81.0, "Rajesh Bhanu", 16, 22459, 10, 'B');
//		Student std3 = new Student("Tejpal Singh", 20, 29011, 10, 'B');
//		Student std4 = new Student("Shubh Raut", 21, 29011, 12, 'A');
//		List<Student> stdDetails = List.of(std1,std2,std3,std4);
//		ser.insertAllStudent(stdDetails).forEach(System.out::println);
		
//		find by id
//		System.out.println(ser.getStudentInfo("661ca0f0d435bd2b78aa44ec"));
		
//		find all by ids
//		ser.getStudentInfiByIds(List.of("661cafded5611b43827c09b3","661cafded5611b43827c09b2")).forEach(System.out::println);;
		
//		get all data in sorting order
//		ser.getStudentsInfo(true, "stdWeight").forEach(System.out::println);
		
//		getting data in page format
		
		ser.getPage(4, true, "stdName").forEach(System.out::println);;
		
	}

}

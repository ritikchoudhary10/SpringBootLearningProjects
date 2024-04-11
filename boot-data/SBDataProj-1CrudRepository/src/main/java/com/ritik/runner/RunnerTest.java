
package com.ritik.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.entity.Student;
import com.ritik.service.IStudentService;

@Component
public class RunnerTest implements CommandLineRunner {
	
	@Autowired
	IStudentService ser;
	
	@Override
	public void run(String... args) throws Exception {

		// save operation
		/*
		 * try { Student std = new Student(null, "Rahul", 9913455556L, "kgn");
		 * System.out.println(ser.addStudent(std)); }catch(Exception e) {
		 * e.printStackTrace(); }
		 */
		/*try
		{
			Student std = new Student(null, "Rahul", 9913455556L, "kgn");
			System.out.println(ser.addStudent(std));
		}catch(
		Exception e)
		{
						e.printStackTrace();
					}*/

		// SaveAll operation

		try {
			List<Student> students = List.of(
					new Student(null,"Ankit",8978978970L,"Jhasi"),
					new Student(null,"Amul",8978978970L,"jodhpur"),
					new Student(null,"Harsh",8978978970L,"Panji"),
					new Student(null,"Chirag",8978978970L,"Banglore"),
					new Student(null,"Mitali",8978978970L,"Trichi")
					);
			System.out.println(ser.addStudents(students));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get All records
		/*
		 * try { ser.getAllStudentsDetails().forEach(System.out::println);
		 * }catch(Exception e) {e.printStackTrace();}
		 */

		// Find total Students
		/*
		 * try { System.out.println("Total no. of Students are "+ser.studentCount());
		 * }catch(Exception e) {e.printStackTrace();}
		 */
		/*try {
			ser.getAllStudentsDetails().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// Find total no. of Students

		/*try {
			System.out.println("Total no. of Students are " + ser.studentCount());
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// checking the record exists or not

		/*try {
			System.out.println(ser.isStudentAvailable(101L));
		} catch (Exception e) {
			e.printStackTrace();
		}
		}*/

		// getting the student record if available no exception record will be displayed

		/*		try {
					System.out.println(ser.getStudentDetails(1011L));
				} catch (Exception e) {
					e.printStackTrace();
				}
		*/

		// when record does not exists it will throw exception
		/*		try {
					System.out.println(ser.getStudentDetails(1011L));
				} catch (Exception e) {
					e.printStackTrace();
				}*/

		// getting record or dummy data 
		/*		try {
					System.out.println(ser.getStudentDetailsOrDummyData(101L));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					System.out.println(ser.getStudentDetailsOrDummyData(1011L));
				} catch (Exception e) {
					e.printStackTrace();
				}
		*/

		// updating the records that exists 

		/*try {
			System.out.println("========================================================================");
			System.out.println(ser.updateStdAdrr(101L, "Khandwa"));
			System.out.println("========================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		//finding all records by ids given
		/*	
			try {
				List<Long> ids = List.of(101L,21L,103L , 105L,108L);
				ser.findAllByStudentIds(ids);
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		//delete atudent record by Id 

		/*	try {
				System.out.println("========================================================================");
				System.out.println(ser.deleteById(1L));
				System.out.println("========================================================================");
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		//deleting by student data 

		/*try {
			System.out.println("========================================================================");
			Student std =new Student(102L,"Ritik",9999999999L , "Khandwa");
			System.out.println(ser.delete(std));
			System.out.println("========================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// delete all by ids 

		/*try {
			List<Long> ids = List.of(1L,101L,102L,118L);
			System.out.println(ser.deleteAllStudentsByIds(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// deleteall entities

		/*try {
			List<Student> students = List.of(
					new Student(106L),
					new Student(107L),
					new Student(108L),
					new Student(109L),
					new Student(110L)
					);
			System.out.println(ser.deleteAllByStudentData( students));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// delete all records in the database

		/*try {
			System.out.println(ser.deleteAllStudentsData());
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

 

package com.ritik.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.object.Address;
import com.ritik.object.Friends;
import com.ritik.object.Student;

@RestController
@RequestMapping("/provider-api")
public class RestProviderClass {

	@GetMapping("/getStudent")
	public ResponseEntity<Student> getData(){
		Student std = new Student(1001,"Raja Shah");
		Long[] monNos= {8989898976L,7657657659L};
		List<String> petNames =List.of("raj","raju","sam");
		Set<String> mailIds = Set.of("raj@gmail.com","raja@yahoo.com","sam@redifmail.com");
		Map<String , Double> allSubMarks = Map.of("Maths" , 87.5,"Physics" , 72.8 , "Chemistry",78.0,"English",76.2,"Hindi" , 98.9);
		List<Friends> friends= List.of(new Friends("Ravi","5 years") , new Friends("Rajesh","4 years" ) , new Friends("himanshu", "16 years"));
		Address adr = new Address("269", "Talwadiya","Khandwa", "MP");
		std.setStdAdrr(adr);
		
		std.setStdPetNames(petNames);
		std.setStdMobNo(monNos);
		std.setStdMailIds(mailIds);
		std.setStdMarks(allSubMarks);
		std.setFriends(friends);
		return new ResponseEntity<Student>(std , HttpStatus.OK);
	}

}

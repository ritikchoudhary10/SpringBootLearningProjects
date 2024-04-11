package com.ritik;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ritik.bean.Patient;
import com.ritik.controller.PatientInfoController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		try{
			PatientInfoController patients = ctx.getBean("ctrlr" , PatientInfoController.class);
			List<Patient> allInfo = patients.getAllInfo("MP", "AP", "TELANGANA");
			allInfo.forEach((patient)->{
				System.out.println(patient);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		((ConfigurableApplicationContext) ctx).close();
	}

}

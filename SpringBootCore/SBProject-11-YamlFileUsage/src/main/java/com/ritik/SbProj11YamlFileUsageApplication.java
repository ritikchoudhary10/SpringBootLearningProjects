package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ritik.sbeans.AdminInfo;
import com.ritik.sbeans.DataInjYaml;
import com.ritik.sbeans.StudentInfo;

@SpringBootApplication
public class SbProj11YamlFileUsageApplication {

	public static void main(String[] args) {
	    ApplicationContext ctx = SpringApplication.run(SbProj11YamlFileUsageApplication.class, args);
	    DataInjYaml bean = ctx.getBean("yaml",DataInjYaml.class);
	    System.out.println(bean);
	    System.out.println("================================================================================");
	    
	    AdminInfo bean2 = ctx.getBean("admin",AdminInfo.class);
	    System.out.println(bean2);
	    System.out.println("================================================================================");
	    StudentInfo bean3 = ctx.getBean("Std",StudentInfo.class);
	    System.out.println(bean3);
	}

}

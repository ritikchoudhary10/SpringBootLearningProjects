package com.ritik;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ritik.bean.Employee;
import com.ritik.controller.EmployeeManagerController;

@SpringBootApplication
public class Application {

	/*
	 * This is we have to configure mannually and also a lengthy process
	 */  
	/*
	 * @Bean 
	 * DataSource getDs() throws Exception{ 
	 * ComboPooledDataSource ds = new ComboPooledDataSource();
	 * ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
	 * ds.setJdbcUrl("jdbc:oracle:thin:@Personal:1521:orcl");
	 * ds.setUser("c##ritik"); ds.setPassword("ritik"); \
	 * return ds; 
	 * 
	 * }
	 */
	  

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeManagerController ctr = ctx.getBean("empController", EmployeeManagerController.class);
		try {
			List<Employee> list = ctr.getDetails("CLERK", "ANALYST", "SALeSMAN");
			if (!list.isEmpty()) {

				list.forEach((emp) -> {
					System.out.println(emp);
				});
			} else {
				System.out.println("Designation not entered properly check spelling");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
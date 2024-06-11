package com.ritik.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component// making this class as spring bean managed by IOC container 
public class ScheduledTasks {

	
	/*  to use Scheduled annotaion the class in which method is annotated must be a
	  spring bean managed by IOC container
	*/
	
	// initialDelay is used to specify after bootstraping is completed in how much
	// 									interval of time this method should be called
	
	// fixedDelay is used to specify the time interval between two consecutive method called 
	
	// here all uniots are in milliseconds ms
	
	/*
	@Scheduled(initialDelay = 1000,fixedDelay = 3000)
	public void generateSalesReport() {
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
	}
	*/
	
	/*@Scheduled(initialDelay = 1000,fixedDelay = 3000)   // this method will through Exception
	public void generateSalesReport(int no) {
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
	}*/
	
//   Exception thrown by above method having parameter 
//		: java.lang.IllegalStateException
//		: Could not create recurring task for @Scheduled method 'generateSalesReport'
//		: Only no-arg methods may be annotated with @Scheduled
	
	// the methods having Scheduled Annotation must be a no param methods else this method annotation will through 
		// IllegalStateException
	
	
		/*@Scheduled                       // this will through Exception
		public void generateSalesReport() {
			System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
		}*/
//		we must specify initial delay or fixedDelay or cron expression
	
	
//	Case-1:  @Scheduled(initialDelay = 2000) point of time
	
	/*@Scheduled(initialDelay = 5000)  
	public void generateSalesReport1() {
		System.out.println("point of time");
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
	}*/
	
	
//   Case-2:  @Scheduled(fixedDelay = 2000)  Period of time
	
	/*@Scheduled(fixedDelay = 5000)   
	public void generateSalesReport2() {
		System.out.println("period of time every 5 sec");
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
	}*/
	
//    Case-3:  When the fixedDelay time is greater than method execution
	/*@Scheduled(fixedDelay = 5000)   
	public void generateSalesReport3() {
		System.out.println("Start ::"+new Date(System.currentTimeMillis()));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
		System.out.println("end ::"+new Date(System.currentTimeMillis()));
	}*/
	
//	Case-4:  When fixedDelay time is less than method execution 
	/*@Scheduled(fixedDelay = 5000)   
	public void generateSalesReport4() {
		System.out.println("Start ::"+new Date(System.currentTimeMillis()));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
		System.out.println("end ::"+new Date(System.currentTimeMillis()));
	}*/
	
//  Case-5 when fixedRate is specified then the task will execute the specified rate of time 
//					if the method takes less time to execute then the remaining time will be 
// 					considered as buffer and after the buffered time the task will be executed
	
	//case 5-a  whenfixed rate is greater than method execution time
	/*@Scheduled(fixedRate = 5000)   
	public void generateSalesReport5a() {
		System.out.println("Start ::"+new Date(System.currentTimeMillis()));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
		System.out.println("end ::"+new Date(System.currentTimeMillis()));
	}	*/
	
	//case5-b when fixed rate is less than method execution time
	//           - the method executes continiouly without any delay
	@Scheduled(fixedRate = 5000)   
	public void generateSalesReport5b() {
		System.out.println("Start ::"+new Date(System.currentTimeMillis()));
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Sales Report generated on::" +new Date(System.currentTimeMillis()));
		System.out.println("end ::"+new Date(System.currentTimeMillis()));
	}
}

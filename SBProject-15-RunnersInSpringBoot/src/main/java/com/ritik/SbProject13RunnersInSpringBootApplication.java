package com.ritik;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbProject13RunnersInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbProject13RunnersInSpringBootApplication.class, args);
		
		
	 
	  /* 
	   * Queue<Integer> q=new LinkedList<>(); System.out.println(q.size()); q.add(9); 
	   * q.add(10); q.add(12); q.add(15); q.add(20); q.add(13); q.add(18); 
	   * System.out.println(q); Queue<Integer> dq=new ArrayDeque<>(); dq.add(30); 
	   * dq.add(22); dq.add(45); dq.add(67); dq.add(19); dq.add(90); 
	   * System.out.println(dq); 
	   */ 
	  Queue<Integer> pq=new PriorityQueue<>(); 
	  pq.add(34); 
	  pq.add(23); 
	  pq.add(23); 
	  pq.add(92); 
	  pq.add(12); 
	  pq.add(100); 
	  System.out.println(pq); 
	  Iterator<Integer> itr=pq.iterator(); 
	  while(itr.hasNext()) { 
	   System.out.print(itr.next()); 
	   System.out.print(","); 
	  } 
	   
	 } 

}

package com.ritik.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestPathController {

	@GetMapping("/")
	public String welcomePage() {
		System.out.println("RequestPathController.welcomePage()");

		return "welcome";
	}

	@GetMapping("/oneparam")
	public String getParam(@RequestParam("sno") Integer sno, Map<String, Object> sharedMemory) {
		System.out.println("RequestPathController.getParam()");
		System.out.println("Request param ::" + sno);
		sharedMemory.put("sno", sno);
		return "request_param_values1";
	}

	@GetMapping("/twoparam")
	public String getParam(@RequestParam("sno") Integer sno, @RequestParam("sname") String sname,
			Map<String, Object> sharedMemory) {
		System.out.println("Request param ::" + sno + "...." + sname);
		System.out.println("RequestPathController.getParam()");
		sharedMemory.put("sno", sno);
		sharedMemory.put("sname", sname);
		return "request_param_values2";
	}

	@GetMapping("/listparam")
	public String getListData(@RequestParam("sno") Integer sno,
							  @RequestParam("sname") String sname,
	 						  @RequestParam("sadd") List<String> addr, 
	 						  Map<String, Object> sharedMemory) {
		
		System.out.println("RequestPathController.getListData()");
		System.out.println("Request param ::" + sno + "...." + sname+"...."+addr);
		sharedMemory.put("sno", sno);
		sharedMemory.put("sname", sname);
		sharedMemory.put("sadd", addr);
		return "request_param_values3";
	}
	
	@GetMapping("/colparam")
	public String getColData( @RequestParam("sadd") List<String> addr1, 
							  @RequestParam("sadd") Set<String> addr2,
							  @RequestParam("sadd") String[] addr3,
	 						  Map<String, Object> sharedMemory) {
		
		System.out.println("RequestPathController.getColData()");
		System.out.println("Request param :\t" + addr1 + "\n\t\t" + addr2+"\n\t\t"+addr3);
		sharedMemory.put("addr1", addr1);
		sharedMemory.put("addr2", addr2);
		sharedMemory.put("addr3", Arrays.toString(addr3));
		return "request_param_values4";
	}
	
	@GetMapping("/novalue1")
	public String getDefaultValues(@RequestParam(name="sno",defaultValue = "-1110" ) Integer sid,
								@RequestParam("sname") String sname,
								Map<String, Object> sharedMemory) {
		System.out.println("RequestPathController.getDefaultValues()");
		sharedMemory.put("sno", sid);
		sharedMemory.put("sname", sname);
		return "request_param_values5";
	}
	@GetMapping("/novalue2")
	public String getNullValues(@RequestParam(name="sno",required = false) Integer sid,
			@RequestParam("sname") String sname,
			Map<String, Object> sharedMemory) {
		System.out.println("RequestPathController.getNullValues()");
		System.out.println("Request Param ::"+sid +"......."+sname);
		sharedMemory.put("sno", sid);
		sharedMemory.put("sname", sname);
		return "request_param_values6";
	}
	
	@GetMapping("/exception")
	public String passedWrongRequestParamType(@RequestParam Integer sno,
											  @RequestParam("sname") String sname
											) {
		return "welcome";
	}
	
	

}

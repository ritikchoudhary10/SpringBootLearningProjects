package com.ritik.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataRenderingController {

	@RequestMapping("/")//taken as the welcome page method
	public String welcomeDefault() {
		//returning Logical View Name
		return "welcome";
	}
	
	@RequestMapping("/welcome")//taken as the welcome page method
	public void welcome() {
		// here the logical view name will be of request path type i.e welcome
	}
	
														//LVN--> Logical view name
//															   |	
	@RequestMapping("/data1")   //here the return type is not LVN type so the LVN will be taken as requst path name i.e data1
								
	public Map<String, Object> dataRenderingOption1() {
		System.out.println("DataRenderingController.dataRenderingOption1()");
		Map<String, Object> map=new HashMap<String, Object>();   // creating shared memory
		map.put("attr1","value-1" );	//adding attributes
		map.put("attr2", new Date());
		return map; // returning shared memory
	}
	
	@RequestMapping("/data2") // return type in not String type so logical view name is request path name
	public ModelMap dataRenderingOption2() {		
		System.out.println("DataRenderingController.dataRenderingOption2()");
		ModelMap map = new ModelMap();   // creating shared memory
		map.put("attr1","value-1");								
		map.put("attr2", new Date());
		return map;// returning shared memory
	}
	
	@RequestMapping("/data3")// return type in not String type so logical view name is request path name
	public Model dataRenderingOption3() { 
		System.out.println("DataRenderingController.dataRenderingOption3()");
		Model map =new BindingAwareModelMap();  // creating shared memory
		map.addAttribute("attr1","value-1");
		map.addAttribute("attr2", new Date());
		return map;// returning shared memory
	}
	
	@RequestMapping("/data4")// return type in not String type so logical view name is request path name
	public ExtendedModelMap dataRenderingOption4() { //ExtendedModelMap(super type obj as shared memory
		System.out.println("DataRenderingController.dataRenderingOption4()");
		ExtendedModelMap map = new ExtendedModelMap();  // creating shared memory
		map.addAttribute("attr1","value-1");
		map.addAttribute("attr2", new Date());
		return map;// returning shared memory
	}
	
	@RequestMapping("/data5")// return type in not String type so logical view name is request path name
	public LinkedHashMap<String, Object>  dataRenderingOption5() { 
		System.out.println("DataRenderingController.dataRenderingOption5()");
		LinkedHashMap<String, Object> map=new LinkedHashMap<String, Object>();	// creating shared memory
		map.put("attr1","value-1");
		map.put("attr2", new Date());
		return map;// returning shared memory
	}
	
	@RequestMapping("/data6")// return type in not String type so logical view name is request path name
	public HashMap<String, Object> dataRenderingOption6() {
		System.out.println("DataRenderingController.dataRenderingOption6()");
		HashMap<String, Object> map=new HashMap<String, Object>();	// creating shared memory
		map.put("attr1","value-1");
		map.put("attr2", new Date());
		return map;// returning shared memory
	}
}//end class

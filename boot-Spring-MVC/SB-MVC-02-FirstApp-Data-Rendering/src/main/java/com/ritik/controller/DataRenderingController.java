package com.ritik.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
				Hierarcy of BindiangAwareModelMapObject
				
				Object(c)   		     Map(I)
					|extends				|implements
					|_________    -----------
							  |  |
							AbstractMap(AC)
								|(extends)
								|
							HashMap(c)
								|(extends)
								|			
						LinkedHashMap<String ,Object>(c)    
						        |(extends)
						        |
						      Modelmap(c)
						      	|(extends)
						      	|
						     ExtendedModelMap(c)
						     	|(extends)
						     	|							Model(I)
								|							   |
						(c)BindingAwareModelMap----------------|
												(implements)
*/

@Controller
public class DataRenderingController {

	@RequestMapping("/")//taken as the welcome page method
	public String welcome() {
		//returning Logical view name 
		return "welcome";
	}
	
	
	// Best Approach among all
	@RequestMapping("/data1")   
								//BindingAwareModelMap Object will be created by Dispature Servlet as shared memory request scope object
	public String dataRenderingOption1(Map<String, Object> map) {//Map class impl obj(BindingAwareModelMap)  is the shared memory 
																		//created for storing model data in request scope
		System.out.println("DataRenderingController.dataRenderingOption1()");
		map.put("attr1","value-1" );								
		map.put("attr2", new Date());
		return "view1";
	}
	
	@RequestMapping("/data2")//BindingAwareModelMap Object will be created by Dispature Servlet as shared memory request scope object
	public String dataRenderingOption2(ModelMap map) {		//ModelMap class(super type) Object is the shared memory 
																//created for storing model data in request scope
		System.out.println("DataRenderingController.dataRenderingOption2()");
		map.put("attr1","value-1");								
		map.put("attr2", new Date());
		return "view2";
	}
	
	@RequestMapping("/data3")
	public String dataRenderingOption3(Model map) { //(interface whose one implementation class is BindingAwareModelMap class
		System.out.println("DataRenderingController.dataRenderingOption3()");
		map.addAttribute("attr1","value-1");
		map.addAttribute("attr2", new Date());
		return "view3";
	}
	
	@RequestMapping("/data4")
	public String dataRenderingOption4(ExtendedModelMap map) { //ExtendedModelMap(super type) obj as shared memory
		System.out.println("DataRenderingController.dataRenderingOption4()");
		map.addAttribute("attr1","value-1");
		map.addAttribute("attr2", new Date());
		return "view4";
	}
	
	@RequestMapping("/data5")
	public String dataRenderingOption5(LinkedHashMap<String, Object> map) { //LinkedHashMap(super type) obj as shared memory
		System.out.println("DataRenderingController.dataRenderingOption5()");
		map.put("attr1","value-1");
		map.put("attr2", new Date());
		return "view5";
	}
	
	@RequestMapping("/data6")
	public String dataRenderingOption6(HashMap<String, Object> map) { //HashMap (super type) obj as shared memory
		System.out.println("DataRenderingController.dataRenderingOption6()");
		map.put("attr1","value-1");
		map.put("attr2", new Date());
		return "view6";
	}
}

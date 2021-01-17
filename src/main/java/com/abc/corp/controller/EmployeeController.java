package com.abc.corp.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.corp.modal.Employee;
import com.abc.corp.modal.Response;
import com.abc.corp.service.EmplyeeService;

@RestController("/employee")
public class EmployeeController {

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	@Autowired
	private EmplyeeService empService;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee employee) {
	ResponseEntity<Response> responseObj= new ResponseEntity<Response>(HttpStatus.OK); 
	boolean result=false;	
	Long startTime = System.currentTimeMillis();
	try {
		
		result = empService.insertData(employee);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Invalid request");
			responseObj.status(HttpStatus.BAD_REQUEST);
		}
		logger.info("Total time taken to insert operation : {}",System.currentTimeMillis()-startTime);
	Response res=new Response(0L,result);
		return new ResponseEntity<Response>(res,HttpStatus.OK);
		
	}
	
	@GetMapping("/dept")
	public ResponseEntity<Response> getDeptWiseCount(){
		
		empService.getDeptWiseCount();
		
		return null;
	}
	
	@GetMapping("/count")
	public ResponseEntity<Response> getTotalCount(){
		
		empService.getCount();
		
		return null;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Response> updateEmployee(){
		
		empService.updateData();
		
		return null;
	}
	
}

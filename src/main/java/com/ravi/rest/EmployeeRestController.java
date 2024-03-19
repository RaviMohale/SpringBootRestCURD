package com.ravi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.ravi.binding.EmployeeForm;
import com.ravi.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	
	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/create")
	public ResponseEntity<String> saveEmp(@RequestBody EmployeeForm form){		
		String saveEmp = empService.saveEmp(form);
		return new ResponseEntity<String>(saveEmp,HttpStatus.OK);
		
	}
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeForm>>  getAllEmpEntity(){
		List<EmployeeForm> allEmp = empService.getAllEmp();
		return new ResponseEntity<>(allEmp, HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<EmployeeForm> getEmp(@PathVariable("empId")Integer empId) throws Exception{
	 EmployeeForm emp = empService.getEmp(empId);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmp(@PathVariable("empId")Integer empId,@RequestBody EmployeeForm form){
		
		 String updateEmp = empService.updateEmp(empId, form);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmp(@PathVariable("empId")Integer empId ){
		empService.deleteEmp(empId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

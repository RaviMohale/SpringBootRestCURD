package com.ravi.service;

import java.util.List;

import com.ravi.binding.EmployeeForm;
import com.ravi.entity.Employee;

public interface EmployeeService {
	
	
	public String saveEmp(EmployeeForm form);
	
	
	public List<EmployeeForm> getAllEmp();
	
	
	public EmployeeForm getEmp(Integer empId) throws Exception;
	
	
	public String updateEmp(Integer empId,EmployeeForm form);
	
	
	public void deleteEmp(Integer empId);
	
	

}

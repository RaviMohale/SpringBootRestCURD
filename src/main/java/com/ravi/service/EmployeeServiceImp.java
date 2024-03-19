package com.ravi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.binding.EmployeeForm;
import com.ravi.entity.Employee;
import com.ravi.exception.UserNotFoundException;
import com.ravi.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp  implements EmployeeService{
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public String saveEmp(EmployeeForm form) {
		
		Employee emp = new Employee();
		
		BeanUtils.copyProperties(form, emp);
		
		empRepo.save(emp);
		
		return "Employee Save Successfully";
	}
	
	@Override
	public List<EmployeeForm> getAllEmp() {
		
		List<Employee> findAll = empRepo.findAll();
		
		List<EmployeeForm> empForm = new ArrayList<>();
		
		for(Employee emp : findAll) {
			EmployeeForm  form = new EmployeeForm();
			BeanUtils.copyProperties(emp, form);
			empForm.add(form);
			
		}
		return empForm;
	}
	
	@Override
	public EmployeeForm getEmp(Integer empId)throws Exception {
		
		Optional<Employee> optional = empRepo.findById(empId);
		
		if(optional.isPresent()) {
			Employee employee = optional.get();
			
			EmployeeForm form = new EmployeeForm();
			
			BeanUtils.copyProperties(employee, form);
			return form;
		}else {
			throw new UserNotFoundException("User Not Found");
		}

	}
	
	@Override
	public String updateEmp(Integer empId, EmployeeForm form) {
		
		Optional<Employee> optional = empRepo.findById(empId);
		
		if(optional.isPresent()) {
			Employee employee = optional.get();
			employee.setEmpName(form.getEmpName());
			employee.setEmpEmail(form.getEmpEmail());
			employee.setEmpAddress(form.getEmpAddress());
			employee.setEmpBranch(form.getEmpBranch());
			
		empRepo.save(employee);
			
		}else {
			throw new UserNotFoundException("Please enter the correct user Id");
		}
		return "Employee update successfully";
		
		
	}
	
	@Override
	public void deleteEmp(Integer empId) {
		empRepo.deleteById(empId);
		
	}


}

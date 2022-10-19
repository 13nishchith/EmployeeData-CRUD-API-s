package com.employee.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.entity.Employee;
import com.employee.employee.entity.EmployeeMain;
//import com.employee.employee.exception.invalidException;
import com.employee.employee.service.EmployeeService;
import com.employee.employee.service.EmployeeServiceInterface;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceInterface employeeService;
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee) throws Exception {

		employeeService.addEmployee(employee);
	}

	@PostMapping("/employee/header")
	public Employee addEmployeeHeader(@Valid @RequestHeader @RequestBody EmployeeMain employeeMain) throws Exception{
		return employeeService.addEmployeeHeader(employeeMain);
	}
	
	@PutMapping("/employee/{employeeid}")
	public void updateEmployee(@PathVariable int employeeid ,@RequestBody Employee employee) throws Exception {
			employeeService.updateEmployee(employeeid, employee);
	}
	@PutMapping("employee/header/{employeeid}")
	public void updateEmployeeHeader(@PathVariable int employeeid,@RequestBody EmployeeMain employeeMain ) throws Exception {
		employeeService.updateEmployeeHead(employeeMain, employeeid);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() throws Exception{
		return employeeService.getAllEmployee();
	}
	@GetMapping("/employee/{employeeid}")
	public Employee getEmployee(@PathVariable int employeeid) throws Exception {
		return employeeService.getEmployeeById(employeeid);
	}
	
	@DeleteMapping("/employee/{employeeid}")
	public void deleteEmployee(@PathVariable int employeeid) throws Exception  {
			employeeService.deleteEmployee(employeeid);
	}

}
package com.employee.employee.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.entity.Employee;
import com.employee.employee.entity.EmployeeMain;
import com.employee.employee.repository.EmployeeRepository;



@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	EmployeeRepository employeeRepository;


	List<String> validDesignation = Arrays.asList("Trainee","System Engineer","Software Developer","Test Lead", "Team Lead and Manager");
	
	@Override
	public void addEmployee(Employee employee) throws Exception  {		
		
		String fullName = employee.getFirstName() + employee.getMiddleName();
		if(fullName.length()> 30 )
			{
				throw new Exception("Size should be lesser than 30 characters");
			}
		boolean designationFlag = false; 
		for(String designation:validDesignation) {
			if(designation.equalsIgnoreCase(employee.getDesignation())) {
				designationFlag = true;
				employee.setDesignation(designation);
				break;
			}
		}
		if(!designationFlag) {
			throw new Exception("designation should be valid value");
		}
		
//		employee.setCreated_By(employee.getFirstName());
		employeeRepository.save(employee);
	
	}
	@Override
	public Employee addEmployeeHeader(EmployeeMain employeeMain) throws Exception {
		String fullName = employeeMain.getEmployee().getFirstName() + employeeMain.getEmployee().getMiddleName();
		if(fullName.length()> 30)
			{
				throw new Exception("Size should be lesser than 30 characters");
			}
		employeeMain.getEmployee().setCreated_TimeStamp(LocalDateTime.now());
		employeeMain.getEmployee().setLast_Updated_Timestamp(LocalDateTime.now());
		employeeMain.getEmployee().setCreated_By(employeeMain.getHeader().getUsedId());
		return employeeRepository.save(employeeMain.getEmployee());
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception{
		if(employeeRepository.findAll().isEmpty()) {
			throw new Exception("No record found, insert employee details");
		}
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(int employeeid) throws Exception {
		if(employeeRepository.findById(employeeid).isEmpty()) {
			throw new Exception("No employee record found");
		}
		return employeeRepository.findById(employeeid).get();
	}
	
	@Override
	public void updateEmployee(int employeeid,Employee employee) throws Exception {
		if(employeeRepository.findById(employeeid).isPresent()) {
			Employee oldEmployee = employeeRepository.findById(employeeid).get();	
			oldEmployee.setFirstName(employee.getFirstName());
			oldEmployee.setMiddleName(employee.getMiddleName());
			oldEmployee.setLastName(employee.getLastName());
			oldEmployee.setEmailId(employee.getEmailId());
			oldEmployee.setPhoneNo(employee.getPhoneNo());
			oldEmployee.setDesignation(employee.getDesignation());
//			oldEmployee.setCreated_By(employee.getFirstName());
//			oldEmployee.setLast_Updated_By(employee.getFirstName());
			employeeRepository.save(oldEmployee);
			}
		else {
				throw new Exception ("Employee details Not present");
		}
	}
	@Override
	public void updateEmployeeHeader(int employeeid,EmployeeMain employeeMain) {
		if(employeeRepository.findById(employeeid).isPresent()) {
			Employee employee = employeeRepository.findById(employeeid).get();
			employee.setFirstName(employeeMain.getEmployee().getFirstName());
			employee.setMiddleName(employeeMain.getEmployee().getMiddleName());
			employee.setLastName(employeeMain.getEmployee().getLastName());
			employee.setEmailId(employeeMain.getEmployee().getEmailId());
			employee.setPhoneNo(employeeMain.getEmployee().getPhoneNo());
			employee.setDesignation(employeeMain.getEmployee().getDesignation());
			
			employee.setLast_Updated_By(employeeMain.getHeader().getUsedId());
			employeeRepository.save(employee);
		}
		else {
			System.out.println("Employee details not present");
		}
		

	}
	@Override
	public void updateEmployeeHead(EmployeeMain employeeMain,int employeeid ) throws Exception {
		Optional<Employee> employee = employeeRepository.findById(employeeid);
		if(employee.isPresent()) {
			LocalDateTime check = employee.get().getCreated_TimeStamp();
			LocalDateTime beforesix = LocalDateTime.now().minusMonths(6);
			
			employeeMain.getEmployee().setCreated_TimeStamp(employee.get().getCreated_TimeStamp());
			employeeMain.getEmployee().setCreated_By(employee.get().getCreated_By());
			employeeMain.getEmployee().setLast_Updated_Timestamp(LocalDateTime.now());
			employeeMain.getEmployee().setLast_Updated_By(employeeMain.getHeader().getUsedId());
			employeeMain.getEmployee().setEmployeeId(employeeid);
			
			boolean designationFlag = false; 
			for(String designation:validDesignation) {
				if(designation.equalsIgnoreCase(employeeMain.getEmployee().getDesignation())) {
					designationFlag = true;
					employeeMain.getEmployee().setDesignation(designation);
					break;
				}
			}
			if(!designationFlag) {
				throw new Exception("designation should be valid value");
			}
			
			if(check.isBefore(beforesix)) {
				employeeMain.getEmployee().setDesignation(employeeMain.getEmployee().getDesignation());
			}
			else {
				employeeMain.getEmployee().setDesignation(employee.get().getDesignation());
				System.out.println("You are not completed the six months time period to update designation");
			}
		}
		
		employeeRepository.save(employeeMain.getEmployee());
	}
	
	
	@Override
		public void deleteEmployee(int employeeid) throws Exception {
			if(employeeRepository.findById(employeeid).isEmpty()) {
				throw new Exception("Employee record not found");
			}
			else {
				employeeRepository.deleteById(employeeid);
				System.out.println("employee record deleted successfully");
			}
	
	}
	
	
		
		
	
}

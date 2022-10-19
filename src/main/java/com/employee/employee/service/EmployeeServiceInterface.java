package com.employee.employee.service;

import java.util.List;

import com.employee.employee.entity.Employee;
import com.employee.employee.entity.EmployeeMain;

public interface EmployeeServiceInterface {

	public void addEmployee(Employee employee) throws Exception;
	
	public Employee addEmployeeHeader(EmployeeMain employeeMain) throws Exception;
	
	public List<Employee> getAllEmployee() throws Exception;
	
	public Employee getEmployeeById(int employeeid) throws Exception;
	
	public void updateEmployee(int employeeid,Employee employee) throws Exception;
	
	public void updateEmployeeHeader(int employeeid,EmployeeMain employeeMain);
	
	public void deleteEmployee(int employeeid) throws Exception;
	
	public void updateEmployeeHead(EmployeeMain employeeMain,int employeeid ) throws Exception;
}

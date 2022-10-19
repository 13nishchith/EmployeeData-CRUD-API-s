package com.employee.employee.entity;

import javax.validation.Valid;

public class EmployeeMain {
//	@Valid
	private Header header;
	
	private Employee employee;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}

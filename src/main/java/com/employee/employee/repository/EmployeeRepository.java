package com.employee.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.employee.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value="SELECT * FROM EMPLOYEE_RECORD WHERE PHONE_NO = ?1 AND EMAILID = ?2",nativeQuery=true)
	public Employee getPhonenoAndEmailid(String phoneNo, String emailId);




	
}
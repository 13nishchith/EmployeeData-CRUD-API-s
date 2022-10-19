package com.employee.employee.entity;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "employee_record",uniqueConstraints = { @UniqueConstraint(columnNames = "emailid"),@UniqueConstraint(columnNames = "Phone_no")})
@SequenceGenerator (name = "seq", initialValue = 2483766,allocationSize = 100)
public class Employee {
	@Column (name = "Employee_ID")
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq")
	private int employeeId;
	@NotBlank (message = "First_Name is mandatory ")
	@Pattern (regexp = "[a-zA-Z ]+.?", message = "Accepts only alphabets and space")
	@Column (name = "First_name")
	private String firstName;
	@Pattern (regexp = "[a-zA-Z ]+.?", message = "Accepts only alphabets and space")
	@Column (name = "Middle_name")
	private String middleName;
	@NotBlank (message = "Last_Name is mandatory ")
	@Column (name = "Last_name")
	@Pattern (regexp = "[a-zA-Z]+.?", message = "Accepts only alphabets")
	@Size (min = 1 ,max = 15, message = "lastname should be between 1 to 15")
	private String lastName;
	@NotBlank (message = "Email_id is mandatory ")
	@Column (name = "emailid")
	@Email (regexp = "^(.+)@(.+)$")
	private String emailId;
	@NotBlank (message = "Phone_number is mandatory ")
	@Pattern (regexp = "[0-9]+.?", message = "Accepts only number")
	@Size (max = 10, min = 10)
	@Column (name = "Phone_no")
	private String phoneNo;
	@NotBlank (message = "designation is mandatory ")
	@Column (name = "designation")
	@Pattern (regexp = "[a-zA-Z ]+.?", message = "Accepts only alphabets and space")
	@Size (max = 20)
	private String designation;
	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "created_TimeStamp")
	private LocalDateTime created_TimeStamp;
	@Column (name = "created_By")
	private int created_By;
	@Column (name = "last_Updated_By")
	private int last_Updated_By;
	@UpdateTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "last_Updated_Timestamp")
	private LocalDateTime last_Updated_Timestamp;
	
//	@PrePersist
//	private void onCreate() {
//		created_TimeStamp = new Date(employeeId);
////		last_Updated_Timestamp = new Date(employeeId);
//		}
//	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	public LocalDateTime getCreated_TimeStamp() {
		return created_TimeStamp;
	}


	public void setCreated_TimeStamp(LocalDateTime created_TimeStamp) {
		this.created_TimeStamp = created_TimeStamp;
	}

	

	public LocalDateTime getLast_Updated_Timestamp() {
		return last_Updated_Timestamp;
	}

	public void setLast_Updated_Timestamp(LocalDateTime last_Updated_Timestamp) {
		this.last_Updated_Timestamp = last_Updated_Timestamp;
	}
	
	
	
	public int getCreated_By() {
		return created_By;
	}

	public void setCreated_By(int created_By) {
		this.created_By = created_By;
	}

	public int getLast_Updated_By() {
		return last_Updated_By;
	}

	public void setLast_Updated_By(int last_Updated_By) {
		this.last_Updated_By = last_Updated_By;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String firstName, String middleName,String lastName,String emailId,String phoneNo,String designation, LocalDateTime created_TimeStamp,int created_By,int last_Updated_By,LocalDateTime last_Updated_Timestamp) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.designation = designation;
		this.created_TimeStamp = created_TimeStamp;
		this.created_By = created_By;
		this.last_Updated_By = last_Updated_By;
		this.last_Updated_Timestamp = last_Updated_Timestamp ;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", designation="
				+ designation + ", created_TimeStamp=" + created_TimeStamp + ", created_By=" + created_By
				+ ", last_Updated_By=" + last_Updated_By + ", last_Updated_Timestamp=" + last_Updated_Timestamp + "]";
	}
	
	
	
}

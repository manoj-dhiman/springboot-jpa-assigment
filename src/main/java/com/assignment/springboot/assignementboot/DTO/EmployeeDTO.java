package com.assignment.springboot.assignementboot.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class EmployeeDTO {

	@NotEmpty(message = "Please provide a First Name")
	@Size.List ({@Size(max=60, message="First Name must be less than {max} characters")})
	private String firstName;

	@NotEmpty(message = "Please provide a Sur Name")
	@Size.List ({@Size(max=60, message="Sur Name must be less than {max} characters")})
	private String surName;

	@NotEmpty(message = "Please provide a Email")
	@Size.List ({@Size(max=255, message="Email must be less than {max} characters")})
	private String emailId;

	@NotNull(message = "Please provide a age")
	private Integer age;

	@NotEmpty(message = "Please provide a Department")
	@Size.List ({@Size(max=100, message="Department must be less than {max} characters")})
	private String department;

	@NotEmpty(message = "Please provide a Tile")
	@Size.List ({@Size(max=10, message="Title must be less than {max} characters")})
	private String title;

	@NotEmpty(message = "Please provide a Designation")
	@Size.List ({@Size(max=60, message="Designation must be less than {max} characters")})
	private String designation;

	@NotEmpty(message = "Please provide a Pin code")
	@Size.List ({@Size(max=7, message="Pin Code must be less than {max} characters")})
	private String pincode;

	@NotEmpty(message = "Please provide a DOB")
	private String dob;

	@NotEmpty(message = "Please provide a Joining Date")
	private String  joiningDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
}

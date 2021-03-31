package com.assignment.springboot.assignementboot.model;

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

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee extends BasicEntity {

	@NotEmpty(message = "Please provide a First Name")
	@Column(name = "first_name", nullable = false)
	@Size.List ({@Size(max=60, message="First Name must be less than {max} characters")})
	private String firstName;

	@NotEmpty(message = "Please provide a Sur Name")
	@Column(name = "sur_name", nullable = false)
	@Size.List ({@Size(max=60, message="Sur Name must be less than {max} characters")})
	private String surName;

	@NotEmpty(message = "Please provide a Email")
	@Column(name = "email_address", nullable = false)
	@Size.List ({@Size(max=255, message="Email must be less than {max} characters")})
	private String emailId;

	@Column(name = "age")
	@NotNull(message = "Please provide a age")
	private Integer age;

	@NotEmpty(message = "Please provide a Department")
	@Column(name = "department", nullable = false)
	@Size.List ({@Size(max=100, message="Department must be less than {max} characters")})
	private String department;

	@NotEmpty(message = "Please provide a Tile")
	@Column(name = "title", nullable = false)
	@Size.List ({@Size(max=10, message="Title must be less than {max} characters")})
	private String title;

	@NotEmpty(message = "Please provide a Designation")
	@Column(name = "designation", nullable = false)
	@Size.List ({@Size(max=60, message="Designation must be less than {max} characters")})
	private String designation;

	@NotEmpty(message = "Please provide a Pin code")
	@Column(name = "pin_code", nullable = false)
	@Size.List ({@Size(max=7, message="Pin Code must be less than {max} characters")})
	private String pincode;

	@Column(name = "dob")
	@NotNull(message = "Please provide a DOB")
	private LocalDate dob;

	@Column(name = "joiningDate")
	@NotNull(message = "Please provide a Joining Date")
	private LocalDate  joiningDate;

	@Column(name = "is_deleted")
	private boolean isDeleted;

}

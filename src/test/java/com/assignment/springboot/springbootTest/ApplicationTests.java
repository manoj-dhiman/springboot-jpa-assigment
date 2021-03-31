package com.assignment.springboot.springbootTest;

import com.assignment.springboot.assignementboot.DTO.EmployeeDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ApplicationTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createUser() throws Exception {
		String uri = "/api/v1/employees";
		EmployeeDTO employee = new EmployeeDTO();
		employee.setEmailId("manoj.dhiman71@gmail.com");
		employee.setJoiningDate("2021-02-22");
		employee.setDob("1996-10-22");
		employee.setFirstName("Rehmat");
		employee.setDesignation("Software Engineer");
		employee.setTitle("Mrs");
		employee.setSurName("Dhiman");
		employee.setDepartment("IT");
		employee.setAge(30);
		employee.setPincode("155342");
		super.mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(super.mapToJson(employee))).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void editUser() throws Exception {
		String uri = "/api/v1/employees/1";
		EmployeeDTO employee = new EmployeeDTO();
		employee.setEmailId("Rahul.dhiman71@gmail.com");
		employee.setJoiningDate("2020-02-22");
		employee.setDob("1998-10-22");
		employee.setFirstName("Rahul");
		employee.setDesignation("Software Engineer");
		employee.setTitle("Mrs");
		employee.setSurName("Dhiman");
		employee.setDepartment("IT");
		employee.setAge(30);
		employee.setPincode("345433");
		super.mvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(super.mapToJson(employee))).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void searchEmployees() throws Exception {
		String uri = "/api/v1/employees/search?keyword=Manoj";
		super.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void sortEmployeesData() throws Exception {
		String uri = "/api/v1/employees/sort?column=dob";
		super.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void hardDelete() throws Exception {
		String uri = "/api/v1/employees/hardDelete/1";
		super.mvc.perform(delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void softDelete() throws Exception {
		String uri = "/api/v1/employees/softDelete/1";
		super.mvc.perform(delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
	}
}

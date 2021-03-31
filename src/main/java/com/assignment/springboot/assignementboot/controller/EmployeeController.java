package com.assignment.springboot.assignementboot.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.assignment.springboot.assignementboot.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.assignment.springboot.assignementboot.exception.ResourceNotFoundException;
import com.assignment.springboot.assignementboot.DTO.EmployeeDTO;
import com.assignment.springboot.assignementboot.repository.EmployeeRepository;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody EmployeeDTO employee) {
		Employee perEmployee =  new Employee();
		BeanUtils.copyProperties(employee, perEmployee);
		LocalDate dob = LocalDate.parse(employee.getDob());
		LocalDate joiningDate = LocalDate.parse(employee.getJoiningDate());
		perEmployee.setDob(dob);
		perEmployee.setJoiningDate(joiningDate);
		return employeeRepository.createEmployee(perEmployee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int employeeId,
													  @Valid @RequestBody EmployeeDTO employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId);

		if(employee == null){
		 throw  new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		BeanUtils.copyProperties(employeeDetails, employee, "id");
		LocalDate dob = LocalDate.parse(employeeDetails.getDob());
		LocalDate joiningDate = LocalDate.parse(employeeDetails.getJoiningDate());
		employee.setDob(dob);
		employee.setJoiningDate(joiningDate);
		final Employee updatedEmployee = employeeRepository.createEmployee(employee);
		return ResponseEntity.ok(updatedEmployee);
	}


	@GetMapping("/employees/sort")
	public ResponseEntity<List<Employee>> sortEmployeeData(@RequestParam(value = "column") String column) throws ResourceNotFoundException {

		List<Employee> employeeList = employeeRepository.getSortedEmployeeData(column);

		if(CollectionUtils.isEmpty(employeeList)){
			throw  new ResourceNotFoundException("Employees Data Not Found");
		}

		return ResponseEntity.ok(employeeList);
	}

	@GetMapping("/employees/search")
	public ResponseEntity<List<Employee>> searchEmployeeData(@RequestParam(value = "keyword") String searchValue) throws ResourceNotFoundException {

		List<Employee> employeeList = employeeRepository.searchEmployeeData(searchValue);

		if(CollectionUtils.isEmpty(employeeList)){
			throw  new ResourceNotFoundException("Employees Data Not Found");
		}

		return ResponseEntity.ok(employeeList);
	}

	@DeleteMapping("/employees/hardDelete/{id}")
	public ResponseEntity<String> hardDelete(@PathVariable(value = "id") int id) throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(id);

		if(employee == null){
			throw  new ResourceNotFoundException("Employee not found for this id :: " + id);
		}

		employeeRepository.deleteUserById(id);

		return ResponseEntity.ok("User Hard Deleted Successfully.");
	}

	@DeleteMapping("/employees/softDelete/{id}")
	public ResponseEntity<String> softDelete(@PathVariable(value = "id") int id) throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(id);

		if(employee == null){
			throw  new ResourceNotFoundException("Employee not found for this id :: " + id);
		}

		employee.setDeleted(true);
		employeeRepository.createEmployee(employee);
		return ResponseEntity.ok("User Soft Deleted Successfully.");
	}
}

package com.assignment.springboot.assignementboot.repository;

import com.assignment.springboot.assignementboot.DTO.EmployeeDTO;
import com.assignment.springboot.assignementboot.model.Employee;

import java.util.List;

public interface EmployeeRepository{

    Employee findById(int employeeId);

    Employee createEmployee(Employee employee);

    List<Employee> getSortedEmployeeData(String column);

    List<Employee> searchEmployeeData(String searchValue);

    void deleteUserById(int id);
}

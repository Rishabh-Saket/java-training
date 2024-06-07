package com.shiavnski.manytomany.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiavnski.manytomany.employee.entity.Employee;
import com.shiavnski.manytomany.employee.service.EmployeeService;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		Employee saveEmployee=employeeService.saveEmployee(employee);
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping(value = {"/getEmployees", "/{employeeId}"})
	public ResponseEntity<List<Employee>> getEmployee(@PathVariable(required=false) Long employeeId)
	{
		List<Employee> employees= employeeService.getEmployeeDetails(employeeId);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<?> removeEmployee(@PathVariable Long employeeId)
	{
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}/project/{projectId}")
	public Employee assignProjectToEmployee(@PathVariable Long employeeId, @PathVariable Long projectId)
	{
		return employeeService.assignProjectToEmployee(employeeId, projectId);
	}
	
}

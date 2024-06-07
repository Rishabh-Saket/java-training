package com.shiavnski.manytomany.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiavnski.manytomany.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{	
	
}

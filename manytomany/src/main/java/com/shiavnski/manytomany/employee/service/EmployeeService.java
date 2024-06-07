package com.shiavnski.manytomany.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiavnski.manytomany.employee.entity.Employee;
import com.shiavnski.manytomany.employee.repository.EmployeeRepository;
import com.shiavnski.manytomany.project.entity.Project;
import com.shiavnski.manytomany.project.repository.ProjectRepository;

import java.util.*;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployeeDetails(Long employeeId)
	{
		List<Employee> employees=null;
		employees=employeeRepository.findAll();
		employees.forEach((employee)->{
			List<Project> projects=projectRepository.findByEmployeeId(employee.getEmployeeId());
			if(projects!=null)
			{	
				System.out.println("emplyee "+employee.getEmployeeName()+" has "+projects.size()+" projects");
				Set<Project> projectSet=new HashSet<Project>();
				projects.forEach((project)->{
					projectSet.add(project);
				});
				employee.setProjects(projectSet);
			}
		});
		return employees;
	}
	
	public void deleteEmployee(Long employeeId)
	{
		employeeRepository.deleteById(employeeId);
	}
	
	public Employee assignProjectToEmployee(Long employeeId, Long projectId)
	{
		Set<Project> projects=null;
		Employee employee= employeeRepository.findById(employeeId).get();
		Project project= projectRepository.findById(projectId).get();
		projects=employee.getProjects();
		projects.add(project);
		employee.setProjects(projects);
		return employeeRepository.save(employee);
	}	
	
}

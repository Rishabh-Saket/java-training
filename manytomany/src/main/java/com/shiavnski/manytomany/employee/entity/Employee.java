package com.shiavnski.manytomany.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.shiavnski.manytomany.project.entity.Project;

@Entity
@Table(name="employee")
@Data
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeId;
	
	private String employeeName;
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="employee_project",
		joinColumns = @JoinColumn(name="employee_id", referencedColumnName = "employeeId"),
		inverseJoinColumns = @JoinColumn(name="project_id", referencedColumnName = "projectId")		
	)
	@Fetch(FetchMode.JOIN)
	private Set<Project> projects=new HashSet<Project>();
}

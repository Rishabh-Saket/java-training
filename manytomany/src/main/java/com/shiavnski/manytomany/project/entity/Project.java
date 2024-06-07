package com.shiavnski.manytomany.project.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shiavnski.manytomany.employee.entity.Employee;

@Entity
@Table(name="project")
@Data
public class Project 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	
	private String projectName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees=new HashSet<Employee>();
}

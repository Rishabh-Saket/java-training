package com.shiavnski.manytomany.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiavnski.manytomany.project.entity.Project;
import com.shiavnski.manytomany.project.service.ProjectService;

import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController 
{
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/save")
	public ResponseEntity<Project> addProject(@RequestBody Project project)
	{
		Project savedProject=projectService.saveProject(project);
		return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
	}
	
	@GetMapping(value= {"/getProjects","/{projectId}"})
	public List<Project> getProjects(@PathVariable(required = false) Long projectId)
	{
		return projectService.getProjectDetails(projectId);
	}
	
	@DeleteMapping("/delete/{projectId}")
	public ResponseEntity<?> removeProject(@PathVariable Long projectId)
	{
		projectService.deleteProject(projectId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

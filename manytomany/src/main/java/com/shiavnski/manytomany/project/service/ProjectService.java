package com.shiavnski.manytomany.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiavnski.manytomany.project.entity.Project;
import com.shiavnski.manytomany.project.repository.ProjectRepository;
import java.util.*;

@Service
public class ProjectService 
{
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project)
	{
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long projectId)
	{
		projectRepository.deleteById(projectId);
	}
	
	public List<Project> getProjectDetails(Long projectId)
	{
		if(projectId!=null)
		{
			return projectRepository.findAllByProjectId(projectId);
		}
		return projectRepository.findAll();
	}
}

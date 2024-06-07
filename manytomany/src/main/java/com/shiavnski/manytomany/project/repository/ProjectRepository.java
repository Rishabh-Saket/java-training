package com.shiavnski.manytomany.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shiavnski.manytomany.project.entity.Project;
import java.util.*;

public interface ProjectRepository extends JpaRepository<Project, Long> 
{
	@Query("SELECT p FROM Project p JOIN p.employees e WHERE e.employeeId = :employeeId")
    List<Project> findByEmployeeId(@Param("employeeId") Long employeeId);
	
	List<Project> findAllByProjectId(Long projectId);
}

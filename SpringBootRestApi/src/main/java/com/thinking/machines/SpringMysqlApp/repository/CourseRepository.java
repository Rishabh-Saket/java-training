package com.thinking.machines.SpringMysqlApp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinking.machines.SpringMysqlApp.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable>
{

}

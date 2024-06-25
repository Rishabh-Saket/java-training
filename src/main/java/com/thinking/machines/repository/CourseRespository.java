package com.thinking.machines.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinking.machines.entity.Course;

public interface CourseRespository  extends JpaRepository<Course, Serializable>
{

}

/*
 * create a interface to get  a data
 *  delete a data
 *  insert a data
 * */

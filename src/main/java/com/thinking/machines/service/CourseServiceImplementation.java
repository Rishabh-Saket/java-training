package com.thinking.machines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinking.machines.entity.Course;
import com.thinking.machines.exceptions.CourseNotFoundException;
import com.thinking.machines.repository.CourseRespository;

@Service
public class CourseServiceImplementation implements CourseService 
{
	
	@Autowired
	private CourseRespository courseRespository;
	/*
	 * object of CourseRepository will be created in singleton pattern
	 * if courseRepository object is not created then it will be created by spring boot
	 * if it is created then the object will not be created and its reference willl be passed
	 * */
	
	@Override
	public String upsert(Course course) {
		// TODO Auto-generated method stub
		courseRespository.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById=courseRespository.findById(cid);
		if(!findById.isPresent())
		{
			throw new CourseNotFoundException("Record not found");
		}
		return findById.get();
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRespository.findAll(); 
	}

	@Override
	public String deleteById(Integer cid) {
		// TODO Auto-generated method stub
		if(courseRespository.existsById(cid))
		{
			courseRespository.deleteById(cid);
			return "Delete success";
		}
		return "Record not found";
	}

}

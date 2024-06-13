package com.thinking.machines.SpringMysqlApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinking.machines.SpringMysqlApp.entity.Course;
import com.thinking.machines.SpringMysqlApp.repository.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService 
{
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public String upsert(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		// TODO Auto-generated method stub
		Optional<Course> findById=courseRepository.findById(cid);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		// TODO Auto-generated method stub
		if(courseRepository.existsById(cid))
		{
			courseRepository.deleteById(cid);
			return "Delete Success";
		}
		return "No record found";
	}

}

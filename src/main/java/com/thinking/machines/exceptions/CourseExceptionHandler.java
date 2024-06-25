package com.thinking.machines.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseExceptionHandler 
{
	@ExceptionHandler(value= {CourseNotFoundException.class})
	public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException courseNotFoundException)
	{
		CourseException courseException=new CourseException(
				courseNotFoundException.getMessage(),
				courseNotFoundException.getCause(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(courseException,HttpStatus.NOT_FOUND);
	}
}

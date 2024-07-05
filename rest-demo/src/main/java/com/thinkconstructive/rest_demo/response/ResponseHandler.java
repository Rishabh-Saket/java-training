package com.thinkconstructive.rest_demo.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler 
{
	public static ResponseEntity<Object> responseBuilder(
			String message, HttpStatus httpStatus, Object result)
	{
		Map<String, Object> response=new HashMap<>();
		response.put("message", message);
		response.put("httpstatus", httpStatus);
		response.put("data", result);
		
		return new ResponseEntity<>(response, httpStatus);
	}
}

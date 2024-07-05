package com.thinkconstructive.rest_demo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.service.CloudVendorService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorAPIService.class)
class CloudVendorAPIServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CloudVendorService cloudVendorService;
	
	CloudVendor cloudVendorOne;
	CloudVendor cloudVendorTwo;
	List<CloudVendor> cloudVendorsList=new ArrayList<>();
	

	@BeforeEach
	void setUp() 
	{
		cloudVendorOne = new CloudVendor("1", "Amazon",
                "USA", "xxxxx");
        cloudVendorTwo = new CloudVendor("2", "GCP",
                "UK", "yyyyy");
        cloudVendorsList.add(cloudVendorOne);
        cloudVendorsList.add(cloudVendorTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getCloudVendorDetailsTest() throws Exception
	{
		when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
		this.mockMvc.perform(get("/cloudcontroller/1")).andDo(print()).andExpect(status().isOk());
	}

}

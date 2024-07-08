package com.thinkconstructive.rest_demo.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.service.CloudVendorService;


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
	
	@Test
	void getAllCloudVendors() throws Exception
	{
		when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorsList);
		this.mockMvc.perform(get("/cloudcontroller")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void deleteCloudVendorTest() throws Exception
	{
		when(cloudVendorService.deleteCloudVendor("1")).thenReturn("success");
		this.mockMvc.perform(delete("/cloudcontroller/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void createCloudVendorTest() throws Exception
	{
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter owriter=mapper.writer().withDefaultPrettyPrinter();
		String requestJson=owriter.writeValueAsString(cloudVendorOne);
		
		when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("success");

        // Perform POST request and validate response
        ResultActions resultActions = mockMvc.perform(post("/cloudcontroller")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
	}
	
	@Test
	void updateCloudVendorTest() throws Exception
	{
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter owriter=mapper.writer().withDefaultPrettyPrinter();
		String requestJson=owriter.writeValueAsString(cloudVendorOne);
		
		when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("success");

        // Perform POST request and validate response
        ResultActions resultActions = mockMvc.perform(put("/cloudcontroller")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
	}

	
}

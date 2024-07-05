package com.thinkconstructive.rest_demo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import com.thinkconstructive.rest_demo.exceptions.CloudVendorNotFoundException;
import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.repository.CloudVendorRepository;
import com.thinkconstructive.rest_demo.service.CloudVendorService;

public class CloudVendorServiceImplementationTest 
{
	
	@Mock
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	AutoCloseable autoCloseable;
	CloudVendor cloudVendor;
	
	
	
	@BeforeEach
	void setUp()
	{
		autoCloseable=MockitoAnnotations.openMocks(this);
		cloudVendorService=new CloudVendorServiceImplementation(cloudVendorRepository);
		cloudVendor=new CloudVendor("1", "Amazon", "USA", "XXX1");
	}
	
	@AfterEach
	void tearDown()
	{
		try {
			autoCloseable.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Test
	void createCloudVendorTest()
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("success");
	}
	
	@Test
	void updateCloudVendorTest()
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("success");
	}
	
	@Test
	void deleteCloudVendorTest() 
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
		
		doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
		assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("success");
	}

	
	@Test
	void getCloudVendorTest() 
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
		assertThat(cloudVendorService.getCloudVendor("1").getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}

	 
	@Test
	void getByCloudVendorNameTest() 
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(
				new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)) );
		assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
	}
	
	@Test 
	void getAllCloudVendorTest()
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findAll()).thenReturn(
				new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)) );
		assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
	}

}

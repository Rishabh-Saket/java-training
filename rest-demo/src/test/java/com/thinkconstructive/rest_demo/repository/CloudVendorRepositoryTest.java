package com.thinkconstructive.rest_demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.thinkconstructive.rest_demo.model.CloudVendor;

@DataJpaTest // purpose of using this is to let spring boot know to use inbuilt database to data related queries
public class CloudVendorRepositoryTest 
{
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor cloudVendor;
	
	
	@BeforeEach
	void setUp()
	{
		cloudVendor=new CloudVendor("1", "Amazon", "USA", "XXXXXXX1");
		cloudVendorRepository.save(cloudVendor); 
	}
	
	@AfterEach
	void tearDown()
	{
		cloudVendor=null;
		cloudVendorRepository.deleteAll();
	}
	
	// writing test cases to find vendor by name
	// test to success
	
	@Test
	void testFindByVendorName_Found()
	{
		List<CloudVendor> cloudVendorList= cloudVendorRepository.findByVendorName("Amazon");
		assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
		assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}
	
	// test to failure
	@Test
	void testFindByVendorName_NotFound()
	{
		List<CloudVendor> cloudVendorsList= cloudVendorRepository.findByVendorName("GCP");
		assertThat(cloudVendorsList.isEmpty()).isTrue();
	}
	
	
}

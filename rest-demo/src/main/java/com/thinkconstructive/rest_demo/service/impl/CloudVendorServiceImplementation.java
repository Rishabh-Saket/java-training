package com.thinkconstructive.rest_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkconstructive.rest_demo.exceptions.CloudVendorNotFoundException;
import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.repository.CloudVendorRepository;
import com.thinkconstructive.rest_demo.service.CloudVendorService;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService 
{

	@Autowired
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImplementation(CloudVendorRepository cloudVendorRepository)
	{
		this.cloudVendorRepository=cloudVendorRepository;
	}
	 
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "success";
	}

	 
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "success";
	}

	 
	public String deleteCloudVendor(String cloudVendorId) {
		cloudVendorRepository.deleteById(cloudVendorId);
		return "success";
	}

	 
	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Cloud vendor not found");
		return cloudVendorRepository.findById(cloudVendorId).get();
	}

	 
	public List<CloudVendor> getAllCloudVendors() {
		// TODO Auto-generated method stub
		return cloudVendorRepository.findAll();
	}
	
	public List<CloudVendor> getByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorName(vendorName);
    }

}

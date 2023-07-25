package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.exception.CloudVendorNotFoundException;
import com.springboot.crud.model.CloudVendor;
import com.springboot.crud.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService
{

	@Autowired
	private CloudVendorRepository cloudVendorRepo;
	
	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepo.save(cloudVendor);
		return "Successfully added Cloud Vendor";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepo.save(cloudVendor);
		return "Updated Cloud Vendor";
	}

	@Override
	public String deleteCloudVendor(String vendorId) {
		cloudVendorRepo.deleteById(vendorId);
		return "Deleted Cloud Vendor";
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {
		Optional<CloudVendor> cloudVendor = cloudVendorRepo.findById(vendorId);
		if(cloudVendor.isEmpty()) {
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exists.");
		}
		return cloudVendor.get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendor() {
		List<CloudVendor> findAll = cloudVendorRepo.findAll();
		return findAll;
	}
	

}

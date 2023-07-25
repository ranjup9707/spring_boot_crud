package com.springboot.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.CloudVendor;
import com.springboot.crud.response.ResponseHandler;
import com.springboot.crud.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController 
{
	@Autowired
	private CloudVendorService cloudVendorService;
	
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
	}
	
	@PostMapping
	public ResponseEntity<Object> createCloudVendorDetails(@RequestBody CloudVendor vendor) {
		return ResponseHandler.responseBuilder(cloudVendorService.createCloudVendor(vendor), HttpStatus.OK, null);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateCloudVendorDetails(@RequestBody CloudVendor vendor) {
		return ResponseHandler.responseBuilder(cloudVendorService.updateCloudVendor(vendor), HttpStatus.OK, null);
	}
	
	@DeleteMapping("{vendorId}")
	public ResponseEntity<Object> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder(cloudVendorService.deleteCloudVendor(vendorId), HttpStatus.OK, null);
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllCloudVendorDetails(){
		return ResponseHandler.responseBuilder("All Vendor details retrieved successfully", HttpStatus.OK, cloudVendorService.getAllCloudVendor());
	}
}

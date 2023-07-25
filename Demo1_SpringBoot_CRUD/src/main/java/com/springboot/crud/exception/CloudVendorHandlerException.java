package com.springboot.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorHandlerException 
{
	@ExceptionHandler(value = {CloudVendorNotFoundException.class})
	public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException ex){
		CloudVendorException cloudVendorException = new CloudVendorException(ex.getMessage(), 
				ex.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
	}
}

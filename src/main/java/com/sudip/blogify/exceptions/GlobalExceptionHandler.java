package com.sudip.blogify.exceptions;

import com.sudip.blogify.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourseNotFoundExceptions.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourseNotFoundExceptions ex){
		
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse();
		return new ResponseEntity<ApiResponse>(HttpStatus.NOT_FOUND);
		
	}

}
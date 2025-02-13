package com.sudip.blogify.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourseNotFoundExceptions extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public ResourseNotFoundExceptions(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s", resourceName , fieldName , fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


}
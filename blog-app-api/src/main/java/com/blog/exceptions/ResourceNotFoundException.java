//(6) create to handle exception on run time

package com.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resourcename;
	String fieldname;
	long fielValue;
	public ResourceNotFoundException(String resourcename, String fieldname, long fielValue) {
		super(String.format("%s not found with %s:%1", resourcename,fieldname,fielValue));          //msg can pass here
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fielValue = fielValue;
	}
	
	
}

package org.milkyway.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author 
 * Prashanth H<br/>
 * 
 * @see RuntimeException
 */

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		
		super(message);
	}


}

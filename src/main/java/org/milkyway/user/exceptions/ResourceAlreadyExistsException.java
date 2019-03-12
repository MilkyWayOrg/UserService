package org.milkyway.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author 
 * Prashanth H<br/>
 *
 * @see RuntimeException
 * */
@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {


	public ResourceAlreadyExistsException(String message) {
		super(message);
	
	}


}

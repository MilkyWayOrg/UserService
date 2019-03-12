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
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {


	public InvalidArgumentException(String message) {
		super(message);
	
	}

}

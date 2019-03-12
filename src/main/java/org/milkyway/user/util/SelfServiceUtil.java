package org.milkyway.user.util;

import java.util.List;

import org.milkyway.user.exceptions.InvalidArgumentException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
/**
 * 
 * @author 
 * Prashanth H<br/>
 *
 *
 * */
public class SelfServiceUtil {

	public static void throwInvalidArgumentException(Errors errors) {
		String errorMsg = new String();
		List<ObjectError> errorList = errors.getAllErrors();
		for (ObjectError error :errorList) {
			errorMsg+=error.getDefaultMessage()+"; ";
		}
		throw new InvalidArgumentException(errorMsg);
	}
}

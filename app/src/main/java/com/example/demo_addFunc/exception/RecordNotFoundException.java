/**
 * Extends Exception
 */
package com.example.demo_addFunc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Handles record not found with message parameter, passes parameter to parent constructor
	 * 
	 * @param message
	 */
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Handles record not found with message and Throwable parameters, passes parameters to parent constructor
	 * @param message
	 * @param t
	 */
	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}    
}
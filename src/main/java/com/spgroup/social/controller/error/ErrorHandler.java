package com.spgroup.social.controller.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spgroup.social.controller.dto.ResponseError;

/**
 * @author parmod
 *
 */
@RestControllerAdvice
public class ErrorHandler {

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseError handleNotFoundException(UserNotFoundException ex) {
		return new ResponseError(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseError handleNotFoundException(Exception ex) {
		return new ResponseError(ex.getMessage());
	}
}

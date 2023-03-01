package com.milos.PlanetsManager.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityCouldNotBeDeletedException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
 
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
     

	@ExceptionHandler(value = EntityAlreadyExistsException.class)
	public ResponseEntity<String> handleEntityAlreadyExistsException(
			EntityAlreadyExistsException entityAlreadyExistsException) {
		return new ResponseEntity<String>(entityAlreadyExistsException.getMessage(),
				entityAlreadyExistsException.getHttpStatus());
	}

	@ExceptionHandler(value = EntityDoesNotExistException.class)
	public ResponseEntity<String> handleDoesNotExistsException(
			EntityDoesNotExistException entityDoesNotExistException) {
		return new ResponseEntity<String>(entityDoesNotExistException.getMessage(),
				entityDoesNotExistException.getHttpStatus());
	}

	@ExceptionHandler(value = EntityCouldNotBeDeletedException.class)
	public ResponseEntity<String> handleEntityCouldNotBeDeletedException(
			EntityCouldNotBeDeletedException entityCouldNotBeDeletedException) {
		return new ResponseEntity<String>(entityCouldNotBeDeletedException.getMessage(),
				entityCouldNotBeDeletedException.getHttpStatus());
	}
}

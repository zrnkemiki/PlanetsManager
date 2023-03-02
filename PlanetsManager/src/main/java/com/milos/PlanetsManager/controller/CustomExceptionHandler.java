package com.milos.PlanetsManager.controller;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.milos.PlanetsManager.exception.EntityAlreadyExistsException;
import com.milos.PlanetsManager.exception.EntityCouldNotBeDeletedException;
import com.milos.PlanetsManager.exception.EntityDoesNotExistException;
 
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Current Timestamp", new Date());
        objectBody.put("Status", httpStatus.value());

        // Get all errors
        List<String> exceptionalErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        objectBody.put("Errors", exceptionalErrors);

        return new ResponseEntity<>(objectBody, httpStatus);
    }
     

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

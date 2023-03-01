package com.milos.PlanetsManager.exception;

import org.springframework.http.HttpStatus;

public class EntityCouldNotBeDeletedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private String message;

	public EntityCouldNotBeDeletedException() {
	}

	public EntityCouldNotBeDeletedException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

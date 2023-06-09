package dev.natao.projectweb.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.natao.projectweb.services.exceptions.DatabaseException;
import dev.natao.projectweb.services.exceptions.EntityFindException;
import dev.natao.projectweb.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Exception treatment
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) { 
		// Error message
		String error = "Resource not found";
		// Error status
		HttpStatus status = HttpStatus.NOT_FOUND;
		// Creating instance that will be returned
		StandardError err = new StandardError(Instant.now(), // Exception instant  
				status.value(), // HttpStatus .value will return Integer value
				error, 
				exception.getMessage(), 
				request.getRequestURI()); // will return request path	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException (DatabaseException exception, HttpServletRequest request) {
		String error = "Database violation";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(EntityFindException.class)
	public ResponseEntity<StandardError> entityException (EntityFindException exception, HttpServletRequest request) {
		String error = "Entity error";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}

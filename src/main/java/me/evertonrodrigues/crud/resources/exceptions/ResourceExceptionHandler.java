package me.evertonrodrigues.crud.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import me.evertonrodrigues.crud.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String errorMessage = "Não encontrei a informação solicitada";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError defaultError = new StandardError(Instant.now(), status.value(), errorMessage, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(defaultError);
	}

}

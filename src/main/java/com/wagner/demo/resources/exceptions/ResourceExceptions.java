package com.wagner.demo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wagner.demo.services.exceptions.ResourceNotFound;

@ControllerAdvice
public class ResourceExceptions {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<StandardError> resourceNotFount(ResourceNotFound rnf, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, rnf.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}

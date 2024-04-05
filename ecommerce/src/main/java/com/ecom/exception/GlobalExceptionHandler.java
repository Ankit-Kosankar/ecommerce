package com.ecom.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ecom.response.HttpResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<HttpResponse> handleRoleNotFoundException(RoleNotFoundException ex, WebRequest request) {
	    String requestPath = request.getDescription(false).substring(request.getContextPath().length());

	    HttpResponse httpResponse = HttpResponse.builder()
	            .httpStatus(HttpStatus.NOT_FOUND) // Use a more appropriate status code
	            .statusCode(HttpStatus.NOT_FOUND.value())
	            .message(ex.getMessage())
	            .timeStamp(LocalDateTime.now().toString())
	            .path(requestPath)
	            .build();

	    return new ResponseEntity<>(httpResponse, HttpStatus.NOT_FOUND); // Return a 404 status
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpResponse> handleAllExceptions(Exception ex, WebRequest request) {
		
		String requestPath = request.getDescription(false).substring(request.getContextPath().length());
		
		HttpResponse httpResponse = HttpResponse.builder()
		.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
		.message(ex.getMessage())
		.timeStamp(LocalDateTime.now().toString())
		.path(requestPath)
		.devloperMessage("Please Check Logs of the application")
		.build();
		
		HttpResponse errorResponse = new HttpResponse(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        ex.getMessage(),
	        request.getDescription(false)
	    );
	    return new ResponseEntity<>(httpResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}

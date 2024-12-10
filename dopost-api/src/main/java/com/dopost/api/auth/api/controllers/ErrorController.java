package com.dopost.api.auth.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dopost.api.responses.ApiResponse;

@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ApiResponse> handleException(HttpClientErrorException e) {
		String details = "External API responded: %s".formatted(e.getResponseBodyAsString());
		ApiResponse response = ApiResponse.builder().details(details)
				.status(HttpStatus.resolve(e.getStatusCode().value())).build();
		return ResponseEntity.status(e.getStatusCode()).body(response);
	}
}

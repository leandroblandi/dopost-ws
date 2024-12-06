package com.dopost.auth.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dopost.auth.api.exceptions.BaseException;
import com.dopost.auth.api.responses.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ApiResponse> handleException(BaseException e) {
		log.error("HTTP Error {} Details: {}", e.getStatus(), e.getDetails());

		ApiResponse response = ApiResponse.builder().status(e.getStatus()).details(e.getDetails()).build();
		return ResponseEntity.status(e.getStatus()).body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleException(Exception e) {
		log.error("An error was ocurred: {}", e.getMessage());

		ApiResponse response = ApiResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).details(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	

}

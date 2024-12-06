package com.dopost.auth.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dopost.auth.api.responses.ApiResponse;

@RestController
@RequestMapping("${dopost.auth.context.path}")
public class HealthController {

	@GetMapping("/v1/health")
	public ResponseEntity<ApiResponse> check() {
		ApiResponse response = ApiResponse.builder().details("Working!").build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

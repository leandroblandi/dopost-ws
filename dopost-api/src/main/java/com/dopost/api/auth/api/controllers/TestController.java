package com.dopost.api.auth.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dopost.api.auth.api.AuthApi;
import com.dopost.api.auth.api.models.VerifiedTokenResponse;


@RestController
@RequestMapping("${dopost.api.context.path}")
public class TestController {
	@Autowired
	private AuthApi authApi;
	
	@GetMapping("/token/verify")
	public ResponseEntity<VerifiedTokenResponse> verify(@RequestParam String token) {
		return authApi.verify(token);
	}
}

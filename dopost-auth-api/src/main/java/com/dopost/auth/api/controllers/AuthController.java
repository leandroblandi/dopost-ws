package com.dopost.auth.api.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dopost.auth.api.dtos.AuthDto;
import com.dopost.auth.api.dtos.RegisterDto;
import com.dopost.auth.api.responses.TokenResponse;
import com.dopost.auth.api.services.IAuthService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("${dopost.auth.context.path}")
public class AuthController {

	@Autowired
	private IAuthService authService;

	@PostMapping("/v1/register")
	public ResponseEntity<TokenResponse> register(@Valid @RequestBody RegisterDto dto) {
		log.info("Calling AuthService.register with dto: {}", dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(dto));
	}

	@PostMapping("/v1/auth")
	public ResponseEntity<TokenResponse> auth(@Valid @RequestBody AuthDto dto) {
		log.info("Calling AuthService.auth with dto: {}", dto);
		return ResponseEntity.status(HttpStatus.OK).body(authService.auth(dto.getUsername(), dto.getPassword()));
	}
}

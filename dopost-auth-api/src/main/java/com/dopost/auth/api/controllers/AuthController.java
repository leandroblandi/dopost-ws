package com.dopost.auth.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dopost.auth.api.dtos.AuthDto;
import com.dopost.auth.api.dtos.RegisterDto;
import com.dopost.auth.api.responses.TokenResponse;
import com.dopost.auth.api.responses.VerifiedTokenResponse;
import com.dopost.auth.api.services.IAuthService;
import com.dopost.auth.api.services.IJwtService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("${dopost.auth.context.path}")
public class AuthController {

	@Autowired
	private IAuthService authService;

	@Autowired
	private IJwtService jwtService;

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

	@GetMapping("/v1/auth/verify")
	public ResponseEntity<VerifiedTokenResponse> verify(@RequestParam String token) {
		log.info("Calling JwtService.isValidToken with token: {}", token);
		boolean valid = jwtService.isValidToken(token);
		VerifiedTokenResponse response = VerifiedTokenResponse.builder().token(token).valid(valid).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

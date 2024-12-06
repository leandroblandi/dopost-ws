package com.dopost.auth.api.services.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dopost.auth.api.enums.RoleEnum;
import com.dopost.auth.api.responses.TokenResponse;
import com.dopost.auth.api.services.IJwtService;
import com.dopost.auth.api.util.JwtUtil;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtService implements IJwtService {

	@Override
	public TokenResponse generateJwt(String username, List<RoleEnum> roles) {
		log.info("Generating JWT Token for username {} with roles: {}", username, roles);
		return TokenResponse.builder().username(username).token(buildToken(username, roles)).build();
	}

	private String buildToken(String username, List<RoleEnum> roles) {
		return Jwts.builder().subject(username).claim("roles", roles).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + JwtUtil.TOKEN_DURATION_SEGS))
				.signWith(JwtUtil.secretKey).compact();
	}
}

package com.dopost.auth.api.util;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

public class JwtUtil {
	public static final SecretKey secretKey = Jwts.SIG.HS256.key().build();
	public static final String PREFIX_TOKEN = "Bearer ";
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String CONTENT_TYPE = "application/json";
	public static final Long TOKEN_DURATION_SEGS = 3600000L;
	
	private JwtUtil() {
		
	}
}
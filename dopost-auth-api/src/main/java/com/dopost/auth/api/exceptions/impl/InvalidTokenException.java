package com.dopost.auth.api.exceptions.impl;

import java.io.Serial;

import org.springframework.http.HttpStatus;

import com.dopost.auth.api.exceptions.BaseException;

public class InvalidTokenException extends BaseException {

	@Serial
	private static final long serialVersionUID = 6503578310873672620L;

	public InvalidTokenException(String details) {
		super(HttpStatus.UNAUTHORIZED, details);
	}
}

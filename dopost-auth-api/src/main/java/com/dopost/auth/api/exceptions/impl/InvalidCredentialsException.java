package com.dopost.auth.api.exceptions.impl;

import java.io.Serial;

import org.springframework.http.HttpStatus;

import com.dopost.auth.api.exceptions.BaseException;

public class InvalidCredentialsException extends BaseException {

	@Serial
	private static final long serialVersionUID = 2752803606153100453L;

	public InvalidCredentialsException() {
		super(HttpStatus.BAD_REQUEST, "Invalid credentials: please enter not empty and valid credentials");
	}

}

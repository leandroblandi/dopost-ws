package com.dopost.auth.api.exceptions.impl;

import java.io.Serial;

import org.springframework.http.HttpStatus;

import com.dopost.auth.api.exceptions.BaseException;

public class UsernameAlreadyTakenException extends BaseException {

	@Serial
	private static final long serialVersionUID = 1849553577630973900L;

	public UsernameAlreadyTakenException(String username) {
		super(HttpStatus.UNPROCESSABLE_ENTITY,
				"The username '%s' is already taken by another user, please use other".formatted(username));
	}

}

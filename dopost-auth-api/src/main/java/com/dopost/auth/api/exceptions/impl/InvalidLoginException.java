package com.dopost.auth.api.exceptions.impl;

import java.io.Serial;

import org.springframework.http.HttpStatus;

import com.dopost.auth.api.exceptions.BaseException;

public class InvalidLoginException extends BaseException {

	@Serial
	private static final long serialVersionUID = 7172639372381860342L;

	public InvalidLoginException() {
		super(HttpStatus.UNAUTHORIZED, "Invalid login: the user doesn't exists or the credentials aren't correct");
	}

}

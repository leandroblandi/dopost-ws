package com.dopost.api.exceptions;

import java.io.Serial;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PROTECTED)
public abstract class BaseException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -8570463022908613228L;

	protected HttpStatus status;
	protected String details;

	public BaseException(HttpStatus status, String details) {
		super(details);
		setStatus(status);
		setDetails(details);
	}
}

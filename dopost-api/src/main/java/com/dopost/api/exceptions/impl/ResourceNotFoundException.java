package com.dopost.api.exceptions.impl;

import java.io.Serial;

import org.springframework.http.HttpStatus;

import com.dopost.api.exceptions.BaseException;

public class ResourceNotFoundException extends BaseException {

	@Serial
	private static final long serialVersionUID = -4194690001222385474L;

	public ResourceNotFoundException(String id) {
		super(HttpStatus.NOT_FOUND, "Resource with id %s was not found on the system".formatted(id));
	}
}

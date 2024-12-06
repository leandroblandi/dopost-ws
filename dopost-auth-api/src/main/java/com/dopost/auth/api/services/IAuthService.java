package com.dopost.auth.api.services;

import com.dopost.auth.api.dtos.RegisterDto;
import com.dopost.auth.api.responses.TokenResponse;

public interface IAuthService {
	public TokenResponse auth(String username, String password);

	public TokenResponse register(RegisterDto dto);
}

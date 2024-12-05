package com.dopost.auth.api.services;

import java.util.List;

import com.dopost.auth.api.enums.RoleEnum;
import com.dopost.auth.api.responses.TokenResponse;


public interface IJwtService {
	public TokenResponse generateJwt(String username, List<RoleEnum> roles);
}

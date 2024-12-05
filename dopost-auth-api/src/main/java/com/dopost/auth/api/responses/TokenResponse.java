package com.dopost.auth.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenResponse {
	
	@JsonProperty("auth_token")
	private String token;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("authenticated_at")
	private String date;
}

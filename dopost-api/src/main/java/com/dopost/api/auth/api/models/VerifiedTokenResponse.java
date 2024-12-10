package com.dopost.api.auth.api.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class VerifiedTokenResponse {
	@JsonProperty("validated_token")
	private String token;
	
	@JsonProperty("valid_token")
	private boolean valid;
	
	@JsonProperty("status")
	private HttpStatus status;
	
	@JsonProperty("date_time")
	private LocalDateTime date;
}

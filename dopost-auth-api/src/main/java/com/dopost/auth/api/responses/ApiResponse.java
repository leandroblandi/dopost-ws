package com.dopost.auth.api.responses;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ApiResponse {
	
	@Builder.Default
	@JsonProperty("date_time")
	private LocalDateTime date = LocalDateTime.now();
	
	@Builder.Default
	@JsonProperty("response_details")
	private String details = "";
	
	@Builder.Default
	@JsonProperty("status_code")
	private HttpStatus status = HttpStatus.OK;
}

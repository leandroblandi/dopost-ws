package com.dopost.auth.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AuthDto {
	@NotBlank
	private String username;

	@NotBlank
	private String password;
}

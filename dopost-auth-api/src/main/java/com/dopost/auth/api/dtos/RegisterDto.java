package com.dopost.auth.api.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RegisterDto {
	@NotEmpty
	private String fullName;

	@NotEmpty
	@Size(min = 4)
	private String username;

	@NotEmpty
	@Size(min = 12)
	private String password;
}

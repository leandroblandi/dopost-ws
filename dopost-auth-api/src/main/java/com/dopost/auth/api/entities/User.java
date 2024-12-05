package com.dopost.auth.api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dopost.auth.api.enums.RoleEnum;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Document(collation = "dp_auth_users")
@Builder
public class User {
	@Id
	private String id;
	
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotNull
	@Builder.Default
	private List<RoleEnum> roles = new ArrayList<>();
	
	@CreatedDate
	private LocalDateTime whenCreated;
}

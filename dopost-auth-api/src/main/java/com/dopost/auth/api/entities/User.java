package com.dopost.auth.api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dopost.auth.api.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "dp_auth_users")
@Builder
public class User {
	@Id
	@JsonProperty("user_id")
	private String id;

	@NotEmpty
	@JsonProperty("full_name")
	private String fullName;

	@NotEmpty
	@JsonProperty("username")
	private String username;

	@NotEmpty
	@JsonIgnore
	private String password;

	@NotNull
	@JsonProperty("user_roles")
	@Builder.Default
	private List<RoleEnum> roles = new ArrayList<>();

	@CreatedDate
	@JsonProperty("when_created")
	private LocalDateTime whenCreated;
}

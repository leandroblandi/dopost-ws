package com.dopost.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
	@NotBlank
	@Size(min = 2, max = 256)
	@JsonProperty("comment")
	private String comment;
	
	@JsonProperty("user_id")
	private String userId;
}

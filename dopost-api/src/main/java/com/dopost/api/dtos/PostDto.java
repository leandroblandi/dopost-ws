package com.dopost.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PostDto {
	
	@JsonProperty("post_title")
	private String title;
	
	@JsonProperty("post_description")
	private String description;
	
	@JsonProperty("image_url")
	private String imageUrl;
	
	@JsonProperty("user_id")
	private String userId;
}

package com.dopost.api.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document(collection = "dp_post_comment")
public class Comment {
	@Id
	@JsonProperty("comment_id")
	private String id;
	
	@NotBlank
	@Size(min = 2, max = 256)
	@JsonProperty("comment")
	private String comment;
	
	@Builder.Default
	@JsonProperty("likes_count")
	private Long likes = Long.valueOf(0);
	
	@JsonProperty("user_id")
	private String userId;
	
	@CreatedDate
	@JsonProperty("when_created")
	private LocalDateTime date;
}

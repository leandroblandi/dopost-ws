package com.dopost.api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dopost.api.enums.PostStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document(collection = "dp_post")
public class Post {
	@Id
	@JsonProperty("post_id")
	private String id;
	
	@NotBlank
	@Size(min = 2, max = 256)
	@JsonProperty("post_title")
	private String title;

	@JsonProperty("post_description")
	private String description;
	
	@JsonProperty("image_url")
	private String imageUrl;
	
	@Builder.Default
	@JsonProperty("likes_count")
	private Long likes = Long.valueOf(0);
	
	@DBRef
	@Builder.Default
	@JsonProperty("post_comments")
	private List<Comment> comments = new ArrayList<>();
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("post_status")
	@Builder.Default
	private PostStatusEnum status = PostStatusEnum.ACTIVE;
	
	@CreatedDate
	@JsonProperty("when_created")
	private LocalDateTime date;
}

package com.dopost.api.converters.impl;

import org.springframework.stereotype.Component;

import com.dopost.api.converters.ModelConverter;
import com.dopost.api.dtos.PostDto;
import com.dopost.api.entities.Post;

@Component
public class PostConverter extends ModelConverter<Post, PostDto> {

	@Override
	protected Post convertModel(PostDto model) {
		return Post.builder()
				.title(model.getTitle())
				.description(model.getDescription())
				.imageUrl(model.getImageUrl())
				.build();
	}

	@Override
	protected PostDto unconvertModel(Post model) {
		return PostDto.builder().build();
	}
}

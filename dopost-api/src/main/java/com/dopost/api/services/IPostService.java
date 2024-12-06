package com.dopost.api.services;

import org.springframework.data.domain.Page;

import com.dopost.api.dtos.PostDto;
import com.dopost.api.entities.Post;

public interface IPostService {
	public Post create(PostDto dto);
	public Post findOne(String id);
	public Page<Post> findAll(int page);
	public void delete(String id);
}

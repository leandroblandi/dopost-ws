package com.dopost.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dopost.api.converters.impl.PostConverter;
import com.dopost.api.dtos.PostDto;
import com.dopost.api.entities.Post;
import com.dopost.api.enums.PostStatusEnum;
import com.dopost.api.exceptions.impl.ResourceNotFoundException;
import com.dopost.api.repositories.IPostRepository;
import com.dopost.api.services.IPostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImpl implements IPostService {
	
	@Autowired
	private IPostRepository postRepository;
	
	@Autowired
	private PostConverter postConverter;
	
	@Value("${dopost.pagination.size:5}")
	private Integer pageSize;
	
	@Override
	public Post create(PostDto dto) {
		Post post = postConverter.convert(dto);
		return postRepository.save(post);
	}

	@Override
	public Post findOne(String id) {
		Optional<Post> postOptional = postRepository.findById(id);
		
		if (postOptional.isEmpty()) {
			log.error("Resource not found. With id: {}", id);
			throw new ResourceNotFoundException(id);
		}
		
		return postOptional.get();
	}

	@Override
	public Page<Post> findAll(int page) {
		Pageable request = PageRequest.of(page, pageSize);
		return postRepository.findAll(request);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Post post = findOne(id);
		post.setStatus(PostStatusEnum.DELETED);
		postRepository.save(post);
	}
}

package com.dopost.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dopost.api.entities.Post;

@Repository
public interface IPostRepository extends MongoRepository<Post, String> {

}

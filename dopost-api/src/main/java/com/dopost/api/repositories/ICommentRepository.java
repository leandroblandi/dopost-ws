package com.dopost.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dopost.api.entities.Comment;

@Repository
public interface ICommentRepository extends MongoRepository<Comment, String> {

}

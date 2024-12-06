package com.dopost.auth.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dopost.auth.api.entities.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
	public Optional<User> findByUsername(String username);
}

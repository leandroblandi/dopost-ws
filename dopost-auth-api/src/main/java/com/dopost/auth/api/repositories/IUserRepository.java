package com.dopost.auth.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dopost.auth.api.entities.User;
import com.dopost.auth.api.enums.RoleEnum;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
	public Optional<User> findByUsernameAndPassword(String username, String password);
	public Optional<User> findByRole(RoleEnum role);
}

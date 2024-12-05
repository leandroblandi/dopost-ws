package com.dopost.auth.api.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dopost.auth.api.entities.User;
import com.dopost.auth.api.enums.RoleEnum;
import com.dopost.auth.api.exceptions.impl.InvalidCredentialsException;
import com.dopost.auth.api.exceptions.impl.InvalidLoginException;
import com.dopost.auth.api.repositories.IUserRepository;
import com.dopost.auth.api.responses.TokenResponse;
import com.dopost.auth.api.services.IAuthService;
import com.dopost.auth.api.services.IJwtService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService implements IAuthService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IJwtService jwtService;
	
	@Override
	public TokenResponse auth(String username, String password) {
		log.info("Attempting to authenticate username: {} with password: {}", username, password);
		
		if ((username == null || username.isBlank()) || (password == null || password.isBlank())) {
			log.error("Null or empty credentials. Username: {} and Password: {}", username, password);
			throw new InvalidCredentialsException();
		}
		
		Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
		
		if (userOptional.isEmpty()) {
			log.error("User with username: {} doesn't exists", username);
			throw new InvalidLoginException();
		}
				
		List<RoleEnum> roles = userOptional.get().getRoles();
		return jwtService.generateJwt(username, roles);
	}
}

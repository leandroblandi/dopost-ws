package com.dopost.auth.api.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dopost.auth.api.dtos.RegisterDto;
import com.dopost.auth.api.entities.User;
import com.dopost.auth.api.enums.RoleEnum;
import com.dopost.auth.api.exceptions.impl.InvalidCredentialsException;
import com.dopost.auth.api.exceptions.impl.InvalidLoginException;
import com.dopost.auth.api.exceptions.impl.UsernameAlreadyTakenException;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public TokenResponse auth(String username, String password) {
		log.info("Attempting to authenticate username: {} with password: {}", username, password);

		if ((username == null || username.isBlank()) || (password == null || password.isBlank())) {
			log.error("Null or empty credentials. Username: {} and Password: {}", username, password);
			throw new InvalidCredentialsException();
		}

		Optional<User> userOptional = userRepository.findByUsername(username);

		if (userOptional.isEmpty() || !passwordEncoder.matches(password, userOptional.get().getPassword())) {
			log.error("User with username: {} doesn't exists", username);
			throw new InvalidLoginException();
		}

		List<RoleEnum> roles = userOptional.get().getRoles();
		return jwtService.generateJwt(username, roles);
	}

	@Override
	public TokenResponse register(RegisterDto dto) {
		Optional<User> userOptional = userRepository.findByUsername(dto.getUsername());

		if (userOptional.isPresent()) {
			log.info("Someone has tried to use {} username, but is already taken", dto.getUsername());
			throw new UsernameAlreadyTakenException(dto.getUsername());
		}

		buildUser(dto);
		return auth(dto.getUsername(), dto.getPassword());
	}

	private User buildUser(RegisterDto dto) {
		User user = User.builder().fullName(dto.getFullName()).username(dto.getUsername())
				.password(passwordEncoder.encode(dto.getPassword())).roles(buildRoles(false)).build();
		return userRepository.save(user);
	}

	private List<RoleEnum> buildRoles(boolean admin) {
		List<RoleEnum> roles = new ArrayList<>();

		if (admin) {
			roles.add(RoleEnum.ROLE_ADMIN);
		}

		roles.add(RoleEnum.ROLE_USER);
		return roles;
	}
}

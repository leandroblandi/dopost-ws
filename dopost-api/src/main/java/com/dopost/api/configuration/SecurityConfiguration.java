package com.dopost.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain chain(HttpSecurity security) throws Exception {
		return security.authorizeHttpRequests(cfg -> {
			cfg.anyRequest().permitAll();
		}).csrf(cfg -> cfg.disable())
				.sessionManagement(cfg -> cfg.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}
}

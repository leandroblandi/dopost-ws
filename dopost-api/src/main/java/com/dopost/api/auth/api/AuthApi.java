package com.dopost.api.auth.api;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dopost.api.auth.api.models.VerifiedTokenResponse;

@Component
public class AuthApi {
	private RestTemplate template;

	@Value("${dopost.api.auth.base.url}")
	private String basePath;

	public AuthApi() {
		template = new RestTemplate();
	}

	public ResponseEntity<VerifiedTokenResponse> verify(String token) {
		HttpHeaders headers = createHttpHeaders();
		return template.exchange("%s/v1/auth/verify?token=%s".formatted(basePath, token), HttpMethod.GET, createHttpEntity(headers),
				VerifiedTokenResponse.class);
	}

	private HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return headers;
	}

	private HttpEntity<String> createHttpEntity(HttpHeaders headers) {
		return new HttpEntity<>("parameters", headers);
	}
}

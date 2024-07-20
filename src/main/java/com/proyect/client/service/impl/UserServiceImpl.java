package com.proyect.client.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyect.client.model.User;
import com.proyect.client.service.IUserService;
import com.proyect.client.utils.Handle;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.service.url}")
	private String urlUser;
	
	String userPath = "/user";

	@Override
	public Map<String, Object> getAllUsers() {
		
        ResponseEntity<Map<String, Object>> responseEntityAllUsers = restTemplate.exchange(
                urlUser + userPath,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {});

		return Handle.response(responseEntityAllUsers);
	}

	@Override
	public Map<String, Object> getUserById(long userId) {
		
		ResponseEntity<Map<String, Object>> responseEntityGetUserById = restTemplate.exchange(
				urlUser + userPath + "/" + userId, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Map<String, Object>>() {});

		return Handle.response(responseEntityGetUserById);
	}

	@Override
	public Map<String, Object> saveUser(User user) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
		
		ResponseEntity<Map<String, Object>> responseEntitySaveUser = restTemplate.exchange(
				urlUser + userPath, 
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<Map<String, Object>>() {});
		
		return Handle.response(responseEntitySaveUser);
	}

	@Override
	public Map<String, Object> updateUser(User user) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
		
		ResponseEntity<Map<String, Object>> responseEntityUpdateUser = restTemplate.exchange(
				urlUser + userPath, 
				HttpMethod.PUT,
				requestEntity, 
				new ParameterizedTypeReference<Map<String, Object>>() {});
		
		return Handle.response(responseEntityUpdateUser);
	}

	@Override
	public Map<String, Object> deleteUser(long userId) {
		
		ResponseEntity<Map<String, Object>> responseEntityDeleteUserById = restTemplate.exchange(
				urlUser + userPath + "/" + userId, 
				HttpMethod.DELETE,
				null,
				new ParameterizedTypeReference<Map<String, Object>>() {});

		return Handle.response(responseEntityDeleteUserById);
	}

	
	
}

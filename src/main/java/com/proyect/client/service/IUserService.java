package com.proyect.client.service;

import java.util.Map;

import com.proyect.client.model.User;

public interface IUserService {
	
	Map<String, Object> getAllUsers();

    Map<String, Object> getUserById(long userId);

    Map<String, Object> saveUser(User user);

    Map<String, Object> updateUser(User user);

    Map<String, Object> deleteUser(long userId);

}

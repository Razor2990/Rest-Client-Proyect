package com.proyect.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.client.model.User;
import com.proyect.client.service.IUserService;

@RestController
@RequestMapping("client/users")
public class UsersController {
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllUsers() {
		return ResponseEntity.ok(iUserService.getAllUsers());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(iUserService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveUser(@Validated @RequestBody User user) {
        return ResponseEntity.ok(iUserService.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateUser(@Validated @RequestBody User user) {
        return ResponseEntity.ok(iUserService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable long id) {
        return ResponseEntity.ok(iUserService.deleteUser(id));
    }

}

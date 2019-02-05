package com.satyaj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyaj.dao.IUserDao;
import com.satyaj.model.User;

@RestController
@RequestMapping("/company")
public class UserController {

	@Autowired
	private IUserDao service;
		
	@PostMapping("/user")
	public String createUser(@Valid @RequestBody User user){
		service.save(user);
		return "save successfully";
	}
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("/users/{id}")	
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id ){
		return ResponseEntity.ok().body(service.getUserById(id));
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user ){
		User userUpdate=service.getUserById(id);
		userUpdate.setName(user.getName());
		userUpdate.setMobile(user.getMobile());
		userUpdate.setEmail(user.getEmail());;		
		service.save(userUpdate);
		return ResponseEntity.ok().body(userUpdate);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		User user=service.getUserById(id);
		service.deleteUser(id);
		return ResponseEntity.ok().build();
	}
}

package com.satyaj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyaj.model.User;
import com.satyaj.repository.UserRepository;
@Service
public class UserDao implements IUserDao{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void save(User user) {
		repository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}

}

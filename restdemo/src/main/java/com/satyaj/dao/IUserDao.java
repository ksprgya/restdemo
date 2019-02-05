package com.satyaj.dao;

import java.util.List;

import com.satyaj.model.User;

public interface IUserDao {
	public void save(User user);
	public List<User> getAllUser();
	public User getUserById(Long id);	
	public void deleteUser(Long id);
	
}

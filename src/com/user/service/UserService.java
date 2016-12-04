package com.user.service;

import java.util.Date;
import java.util.List;

import com.user.model.User;

public interface UserService {
	
	public void createUser(String id, String name, Date startDate);
	
	public List<User> listUsers();
	
	public void deleteUser(String userId);
}

package com.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.user.model.User;

public interface UserDAO {
	
	public void createUser(User user) throws SQLException;
	
	public List<User> listUsers() throws SQLException;
	
	public void deleteUser(String userId) throws SQLException;

}

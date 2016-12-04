package com.user.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.user.dao.UserDAO;
import com.user.dao.UserDAOImpl;
import com.user.model.User;

import jersey.repackaged.com.google.common.collect.Lists;

public class UserServiceImpl implements UserService {

	@Override
	public void createUser(String id, String name, Date startDate) {
		System.out.println(startDate);
		User user = new User(id, name, startDate);
		UserDAO userDAO = new UserDAOImpl();
		try {
			userDAO.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> listUsers() {
		UserDAO userDAO = new UserDAOImpl();
		List<User> userList = Lists.newArrayList();
		try {
			userList = userDAO.listUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	@Override
	public void deleteUser(String userId) {
		UserDAO userDAO = new UserDAOImpl();
		try {
			userDAO.deleteUser(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


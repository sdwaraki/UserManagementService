package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.user.model.User;
import com.user.util.DbConnection;

import jersey.repackaged.com.google.common.collect.Lists;

public class UserDAOImpl implements UserDAO{

	@Override
	public void createUser(User user) throws SQLException {
		DbConnection connection = new DbConnection();
		Connection conn = connection.getConnection();
		Statement stmt = conn.createStatement();
		java.sql.Date date = new java.sql.Date(user.getMembershipStartDate().getTime());
		int rowsAffected = stmt.executeUpdate("insert into Users (user_id,user_name,start_date) values ('"
				+ user.getId() + "','" + user.getName() + "','" + date.toString() + "')");
		if (rowsAffected == 0) {
			System.out.println("There was no insert to the table");
		}
		conn.close();
		return;
	}

	@Override
	public List<User> listUsers() throws SQLException {
		DbConnection connection = new DbConnection();
		Connection conn = connection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		List<User> userList = Lists.newArrayList();
		while(rs.next()) {
			User user = new User(rs.getString("user_id"),rs.getString("user_name"),rs.getTimestamp("start_date"));
			userList.add(user);
		}
		conn.close();
		return userList;
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		DbConnection connection = new DbConnection();
		Connection conn = connection.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from users where user_id=?") ;
		stmt.setString(1, userId);
		stmt.executeUpdate();
		conn.close();
	}
}

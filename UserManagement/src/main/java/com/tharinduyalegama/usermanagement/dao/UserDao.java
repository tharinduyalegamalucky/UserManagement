package com.tharinduyalegama.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tharinduyalegama.usermanagement.User;

public class UserDao {

	private String jdbcURL = "jdbc:mysql://127.0.0.1/user_management?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name, email, country) VALUES " + " (?, ?, ? );";
	
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email=?, country=? where id =?;";
	
	public UserDao() {
		
	}
	
	protected Connection getConnection() 
	{
		Connection connection = null;
		try {
			Class.forName("jdbcDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		return connection;
	}
	
	
	// insert user
	
	public void insertUser(User user) throws SQLException{
		
		System.out.println(INSERT_USERS_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			printSQLException(e);
		}
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	
	// select user by id
	
	// select all users
	
	// update user
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

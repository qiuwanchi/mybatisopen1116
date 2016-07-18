package com.secoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		
		String sql = "select * from User where userName=?";
		String url = "jdbc:mysql://10.185.240.132:3306/secooDB";
		String userName = "Order1DB_test";
		String password = "ocCqoQBkeMU9Pb7";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "qiuwanchi");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getLong("id") + " " + resultSet.getString("userName") + " " + resultSet.getString("address"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

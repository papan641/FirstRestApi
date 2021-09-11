package com.jerseydemo.JerseyDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BloggerPostService {
	public void add(UserDetails user) {
		Connection connection = null;
		Statement selectStmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "root");
			selectStmt = connection.createStatement();
			int rs1 = selectStmt.executeUpdate(
					"INSERT INTO blogger_post(first_name,last_name,description)VALUES ('"+user.getFirstName()+"','"+user.getLastName()+" ','hiiii')");
			System.out.println("update:" + rs1);
			ResultSet resultSet = selectStmt.executeQuery("select * from blogger_post");
			while (resultSet.next()) {
				System.out.print(resultSet.getString(1));
				System.out.print(resultSet.getString(2));
				System.out.print(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}

		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
		}

	}
}

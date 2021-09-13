package com.jerseydemo.JerseyDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BloggerPostService {
	Connection connection = null;
	Statement selectStmt = null;

	public BloggerPostService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "root");
			selectStmt = connection.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public PostDetails getPost(int postId) {
		PostDetails pd = new PostDetails();
		try {
			ResultSet resultSet = selectStmt.executeQuery("SELECT * FROM blogger_post where id = '" + postId + "'");
			if (resultSet.next()) {
				pd.setFirstName(resultSet.getString(2));
				pd.setLastName(resultSet.getString(3));
				pd.setDescription(resultSet.getString(4));
			}
			return pd;
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
		}
		return null;
	}

	public PostDetails addPost(PostDetails postDetails) {
		try {
			int rs1 = selectStmt.executeUpdate(
					"INSERT INTO blogger_post(first_name,last_name,description)VALUES ('" + postDetails.getFirstName()
							+ "','" + postDetails.getLastName() + "','" + postDetails.getDescription() + "')");
			return postDetails;
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
		}
		return null;
	}

	public PostDetails editPost(PostDetails postDetails, int postId) {
		System.out.println(postDetails +" "+ postId);
		// updated query
		return postDetails;
	}
}

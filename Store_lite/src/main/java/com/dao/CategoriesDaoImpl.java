package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoImpl extends AbstractDao implements CategoriesDao {
	private Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Statement statement;

	public CategoriesDaoImpl() {
		connection = DBConnection.getConnection();
	}

	public List<String> populateDropDownList(String type) {
		List<String> genres = new ArrayList<String>();
		String query = "SELECT DISTINCT genre  FROM CDs where type=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, type);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				genres.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourcesCloser(preparedStatement, statement, resultSet);
		}
		return genres;
	}
}

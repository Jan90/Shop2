package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.model.CD;
import com.model.Store;

public class CDDaoImpl extends AbstractDao implements CDDao {
	private Connection connection;
	//TODO: statement, result set and prepared statement should not be class members but instead should be method local variables.
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	public CDDaoImpl() {
		connection = DBConnection.getConnection();
	}

	//TODO: huge amount of repetition this and next two methods. Utter violation of the DRY rule. Generalize and reuse them.
	public Collection<CD> getProductList() {
		try {
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT Type,Genre,Name FROM CDs");
			while (resultSet.next()) {
				CD cd = new CD();
				cd.setType(resultSet.getString("Type"));
				cd.setGenre(resultSet.getString("Genre"));
				cd.setName(resultSet.getString("Name"));
				Store.addProduct(cd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourcesCloser(preparedStatement, statement, resultSet);
		}

		return Store.productList;
	}

	public void getProductList(String name) {
		String query = "SELECT Type, Genre, Name FROM CDs WHERE Name LIKE ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + name + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CD cd = new CD();
				cd.setType(resultSet.getString("Type"));
				cd.setGenre(resultSet.getString("Genre"));
				cd.setName(resultSet.getString("Name"));
				Store.addProduct(cd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourcesCloser(preparedStatement, statement, resultSet);
		}
	}

	public void getProductList(String type, String genre)
			throws DataAccessException {
		String query = "SELECT type, genre, name FROM cds WHERE Type=? AND Genre=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, type);
			preparedStatement.setString(2, genre);
			resultSet = preparedStatement.executeQuery();
			System.out.println("");
			while (resultSet.next()) {
				CD cd = new CD();
				cd.setType(resultSet.getString("Type"));
				cd.setGenre(resultSet.getString("Genre"));
				cd.setName(resultSet.getString("Name"));
				Store.addProduct(cd);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourcesCloser(preparedStatement, statement, resultSet);
		}
	}

	public Collection<CD> getNewProducts() {
		List<String> genres = new ArrayList<String>();
		//TODO: you don't need subquery here.
		String query = "SELECT * FROM ("
				+ "SELECT * FROM CDs "
				+ "ORDER BY timestamp  DESC "
				+ ") AS CDdata WHERE CDdata.Genre =? ORDER BY timestamp DESC LIMIT 1";
		try {
			Statement statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT DISTINCT genre FROM CDs");
			while (resultSet.next()) {
				genres.add(resultSet.getString(1));
			}
			for (int i = 0; i < genres.size(); i++) {
				PreparedStatement preparedStatement = connection
						.prepareStatement(query);
				preparedStatement.setString(1, genres.get(i));
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					CD cd = new CD();
					cd.setType(resultSet.getString("Type"));
					cd.setGenre(resultSet.getString("Genre"));
					cd.setName(resultSet.getString("Name"));
					Store.addProduct(cd);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourcesCloser(preparedStatement, statement, resultSet);
		}
		return Store.productList;
	}
}

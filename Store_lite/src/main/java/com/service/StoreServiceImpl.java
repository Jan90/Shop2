package com.service;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

import com.dao.CDDaoImpl;
import com.dao.CategoriesDaoImpl;
import com.dao.DBConnection;
import com.model.CD;

//TODO: this server doesn't seem to do anything.
public class StoreServiceImpl implements StoreService {
	//TODO: not used.
	Connection connection;
	private CDDaoImpl cdDaoImpl = new CDDaoImpl();
	private CategoriesDaoImpl categoriesDaoImpl = new CategoriesDaoImpl();
	public StoreServiceImpl() {
		connection = DBConnection.getConnection();
	}
	@Override
	public List<String> populateGenreDropDownList(String type) {
		return categoriesDaoImpl.populateDropDownList(type);
	}

	@Override
	public Collection<CD> getCDsProductList() {
		return cdDaoImpl.getProductList();
	}

	@Override
	public void getCDsProductList(String name) {
		cdDaoImpl.getProductList(name);

	}

	@Override
	public void getCDsProductList(String type, String genre) {
		cdDaoImpl.getProductList(type, genre);

	}

	@Override
	public Collection<CD> getCDsNewProducts() {
		return cdDaoImpl.getNewProducts();
	}

}

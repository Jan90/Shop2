package com.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.model.CD;

public interface StoreService {
	public List<String> populateGenreDropDownList(String type);

	public Collection<CD> getCDsProductList();

	public void getCDsProductList(String name);

	public void getCDsProductList(String type, String genre)
			throws DataAccessException;

	public Collection<CD> getCDsNewProducts();

}

package com.service;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.model.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestJdbcCategoriesRepositoryImpl {

	StoreServiceImpl storeServiceImpl = new StoreServiceImpl();

	@Test
	public void testPopulateGenreDropDownList() throws Exception {
		List<String> genres = new ArrayList<String>();
		genres.add("Rock");
		genres.add("Country");
		genres.add("Jazz");
		assertEquals(genres,
				storeServiceImpl.populateGenreDropDownList("Audio"));
	}

	@Test
	public void testgetCDsProductList() throws Exception {

		assertEquals(Store.getProductList(),
				storeServiceImpl.getCDsProductList());
	}

	@Test
	public void testGetCDsNewProducts() throws Exception {
		assertEquals(Store.getProductList(),
				storeServiceImpl.getCDsNewProducts());
	}
}
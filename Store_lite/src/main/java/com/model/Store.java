package com.model;

import java.util.ArrayList;
import java.util.List;
import com.model.CD;

public class Store {

	public static List<CD> productList;

	public static List<CD> getProductList() {
		//TODO: why to not simply initialize the product list inline and never have nulls?
		if (productList == null) {
			productList = new ArrayList<CD>();
		}
		return productList;
	}

	public static void addProduct(CD cd) {
		getProductList().add(cd);
	}

	public static void deleteProducts(List<CD> productList) {
		Store.productList.clear();
	}
}

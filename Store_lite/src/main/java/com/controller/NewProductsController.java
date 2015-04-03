package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Store;
import com.service.StoreServiceImpl;

public class NewProductsController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String NEW_PRODUCTS = "newProducts.jsp";
	StoreServiceImpl storeServiceImpl = new StoreServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {

		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		if (Store.getProductList().size() != 0) {
			Store.deleteProducts(Store.productList);
		}
		RequestDispatcher view = request.getRequestDispatcher(NEW_PRODUCTS);
		request.setAttribute("newProducts",
				storeServiceImpl.getCDsNewProducts());
		view.forward(request, response);
	}
}
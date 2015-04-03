package com.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CD;
import com.model.ShoppingCart;

public class ShoppingCartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String forward = "";
	ShoppingCart cart = new ShoppingCart();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		if (request.getParameter("getShoppingCart") != null) {
			forward = "shoppingCart.jsp";
			request.setAttribute("cartProducts", cart.getItems());
		} else if (request.getParameterValues("products[]") != null) {
			String[] products = request.getParameterValues("products[]");
			for (int i = 0, j = 1, k = 2; k < products.length; i += 3, j += 3, k += 3) {
				String type = products[i];
				String genre = products[j];
				String name = products[k];
				CD CDProduct = new CD(name, type, genre);
				cart.addItem(CDProduct);
			}

		} else if (request.getParameter("productIndex") != null) {
			int index = Integer.parseInt(request.getParameter("productIndex"));
			cart.removeProduct(index);
			request.setAttribute("cartProducts", cart.getItems());
			forward = "shoppingCart.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}
}

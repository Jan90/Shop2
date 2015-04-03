package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Store;
import com.service.StoreServiceImpl;

public class CDController extends HttpServlet {
	private static final long serialVersionUID = 2163924803565518494L;
	private static String SHOW_PRODUCT_LIST = "/showProductList.do";
	private static String PRODUCT_LIST = "/productList.jsp";
	private static Integer PAGE_NUMBER = 1;
	StoreServiceImpl storeServiceImpl = new StoreServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		if (Store.productList.size() != 0) {
			Store.deleteProducts(Store.productList);
		}
		if (request.getParameter("getMain") != null) {
			storeServiceImpl.getCDsProductList();
			request.setAttribute("forward", PRODUCT_LIST);
		} else if (request.getParameter("name") != null) {
			storeServiceImpl.getCDsProductList(request.getParameter("name"));
			request.setAttribute("forward", PRODUCT_LIST);
		} else if (request.getParameter("type") != null
				& request.getParameter("genre") != null) {
			storeServiceImpl.getCDsProductList(request.getParameter("type"),
					request.getParameter("genre"));

			request.setAttribute("forward", PRODUCT_LIST);
		}
		RequestDispatcher view = request
				.getRequestDispatcher(SHOW_PRODUCT_LIST);
		request.setAttribute("pageNumber", PAGE_NUMBER);
		view.forward(request, response);
	}
}

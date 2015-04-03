package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.PageInfo;

public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String forward = "";
	Integer pageNumber = 1;
	@SuppressWarnings("rawtypes")
	PageInfo pageInfo = new PageInfo();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		if (request.getAttribute("forward") != null
				& request.getAttribute("pageNumber") != null) {
			forward = (String) request.getAttribute("forward");
			pageNumber = (Integer) request.getAttribute("pageNumber");
		} else if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			forward = "productList.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		pageInfo.setPageSize();
		pageInfo.setPage(pageNumber - 1);
		request.setAttribute("pageCount", pageInfo.getPageCount());
		request.setAttribute("currentPage", pageNumber);
		request.setAttribute("productList", pageInfo.getPageList());
		view.forward(request, response);
	}
}

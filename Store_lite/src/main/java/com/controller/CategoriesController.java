package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.service.StoreServiceImpl;

public class CategoriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreServiceImpl storeServiceImpl = new StoreServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {

		doPost(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException, ServletException {
		String type = request.getParameter("type");
		List<String> genres = storeServiceImpl.populateGenreDropDownList(type);
		JSONArray genresJSON = new JSONArray();
		try {
			for (String genre : genres) {
				JSONObject genreJSON = new JSONObject();
				genreJSON.put("genre", genre);
				genresJSON.put(genreJSON);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.print(genresJSON.toString());
		pw.close();

	}

}

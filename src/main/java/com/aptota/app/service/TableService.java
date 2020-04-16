package com.aptota.app.service;

import java.util.List;

import com.aptota.app.model.RestaurentTable;
import com.aptota.app.model.response.Response;

public interface TableService {
	
	public Response saveTable(RestaurentTable table);
	public List<RestaurentTable> getAllTables();

}

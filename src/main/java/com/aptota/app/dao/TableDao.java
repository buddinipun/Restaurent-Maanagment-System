package com.aptota.app.dao;

import java.util.List;

import com.aptota.app.model.RestaurentTable;
import com.aptota.app.model.response.Response;

public interface TableDao {
	
	Response saveTable(RestaurentTable table);
	List<RestaurentTable> getAllTables();

}

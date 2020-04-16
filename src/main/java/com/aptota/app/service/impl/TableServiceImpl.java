package com.aptota.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.TableDao;
import com.aptota.app.model.RestaurentTable;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.TableService;

@Service
public class TableServiceImpl implements TableService {
	
	@Autowired
	TableDao tableDao;

	@Override
	public Response saveTable(RestaurentTable table) {
	
		Response response = tableDao.saveTable(table);
		return response;
	}

	@Override
	public List<RestaurentTable> getAllTables() {
		// TODO Auto-generated method stub
		return tableDao.getAllTables();
	}
	
	

}

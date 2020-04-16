package com.aptota.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.CategoryDao;
import com.aptota.app.model.ItemType;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public Response saveCategory(ItemType type) {
		
		Response response = categoryDao.saveCategory(type);
		return response;
	}

	@Override
	public List<ItemType> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategoryTypes();
	}

}

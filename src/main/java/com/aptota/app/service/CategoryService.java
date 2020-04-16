package com.aptota.app.service;

import java.util.List;

import com.aptota.app.model.ItemType;
import com.aptota.app.model.response.Response;

public interface CategoryService {
	
	public Response saveCategory(ItemType type);
	public List<ItemType> getAllCategories();

}

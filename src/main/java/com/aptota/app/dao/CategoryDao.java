package com.aptota.app.dao;

import java.util.List;

import com.aptota.app.model.ItemType;
import com.aptota.app.model.response.Response;

public interface CategoryDao {
	
	Response saveCategory(ItemType type);
	List<ItemType> getAllCategoryTypes();

}

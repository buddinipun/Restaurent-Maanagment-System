package com.aptota.app.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.ItemDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemdao;
	
	@Override
	public Response saveMenuItem(Item item) {
		Response response = itemdao.saveItem(item);
		return response;
	}

	@Override
	public List<Item> getAllMenuItems() {
		// TODO Auto-generated method stub
		return itemdao.getAllMenuItems();
	}
	
	@Override
	public List<String> serachItem(String term) {
		// TODO Auto-generated method stub
		return itemdao.searchItem(term);
	}

	@Override
	public Response getItemByName(String name) {
		// TODO Auto-generated method stub
		return itemdao.getItemByName(name);
	}

	@Override
	public Response saveItemMaterials(JSONArray jsonString, int menuItemId) {
		// TODO Auto-generated method stub
		return itemdao.saveItemMaterials(jsonString, menuItemId);
	}

	@Override
	public Response getItemMaterials(int itemId) {
		// TODO Auto-generated method stub
		return itemdao.getItemMaterials(itemId);
	}

	

}

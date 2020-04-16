package com.aptota.app.dao;

import java.util.List;

import org.json.JSONArray;

import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;

public interface ItemDao {
	
	Response saveItem(Item item);
	List<Item> getAllMenuItems();
	public List<String> searchItem(String q);
	public Response getItemByName(String name);
	public Response saveItemMaterials(JSONArray jsonString , int menuItemId);
	public Response getItemMaterials(int itemId);
}

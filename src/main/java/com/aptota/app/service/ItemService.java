package com.aptota.app.service;

import java.util.List;

import org.json.JSONArray;

import com.aptota.app.model.Item;
import com.aptota.app.model.response.Response;

public interface ItemService {

	public Response saveMenuItem(Item item);
	public List<Item> getAllMenuItems();
	public List<String> serachItem(String term);
	public Response getItemByName (String name);
	public Response saveItemMaterials(JSONArray jsonString , int menuItemId);
	public Response getItemMaterials(int itemId);
}

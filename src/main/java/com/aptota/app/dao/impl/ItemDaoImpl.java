package com.aptota.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.HqlParser;
import org.hibernate.internal.SessionImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.aptota.app.dao.ItemDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.ItemMaterial;
import com.aptota.app.model.ItemType;
import com.aptota.app.model.response.GetItemMaterials;
import com.aptota.app.model.response.GetQuotationItem;
import com.aptota.app.model.response.Response;

@Repository
public class ItemDaoImpl implements ItemDao{
	
	@PersistenceContext
	private EntityManager eneitymanager;

	@Override
	public Response saveItem(Item item) {
		Session session = null;
		Response response = null;
		
		
	try {
			session = eneitymanager.unwrap(Session.class);
			System.out.println("1");
			System.out.println("Session is : " + session);
			String itemTypeUpper = (item.getItemName() != null && !item.getItemName().isEmpty() && !item.getItemName().equals("") && item.getItemName().trim().length() > 0) ? item.getItemName().toUpperCase().trim() : item.getItemName();
			
			
			ItemType exsistingItem = (ItemType) session.createCriteria(ItemType.class)
			.add(Restrictions.eq("typeName", item.getItemName()))
			.uniqueResult();
			
			
			if (exsistingItem == null) {
				System.out.println("2");
				session.save(item);
			    response = new Response("SUCCESS", 200, "Menu Item registered successfully", item);
			
			} else {
				System.out.println("3");
				response = new Response("FAILS", 300, "Exsisting Menu Item " , item);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Session is : " + session);
			System.out.println("4");
			System.out.println("error " + e.getMessage());
			e.printStackTrace();
		response = new Response("FAILS", 300, "ERROR on Item registion " , e.getMessage());
		
		} finally {
			System.out.println("5");
			if(session != null && session.isOpen()) {
				
				session.close();
			}
		}
		return response;
	}

	@Override
	public List<Item> getAllMenuItems() {
		Session session = null;
		try {
			session = eneitymanager.unwrap(Session.class);
			 return session.createCriteria(Item.class)
			 .list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			
//			if(session != null && session.isOpen()) {
//				
//				session.close();
////			}
		}
	}
	
	
	@Override
	public List<String> searchItem(String q) {
		List<String> usernames = new ArrayList<String>();

		Session session = eneitymanager.unwrap(Session.class);
		Query query = session
				.createQuery("select  i.itemName from Item i where i.itemName like ?0");
		//query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		usernames  = query.setParameter(0, "%" + q + "%").list();



		return usernames;
	}
		
		
		@Override
		public Response getItemByName(String name) {
			Session session = null;
	        Response response = null;
		    try {

	            session = eneitymanager.unwrap(Session.class);

	            Item exsitingItem = (Item) session.createCriteria(Item.class)
	                    .add(Restrictions.disjunction())
	                    .add(Restrictions.eq("itemName", name))
	                    .uniqueResult();
	            response = new Response("SUCCESS",200,"successfuly recived Item details of name : " + name, exsitingItem);

	        }catch (Exception ex) {
		        ex.printStackTrace();

	            response = new Response("FAILS",300,"Error on  Item details of name : " + name + " : " + ex.getMessage() , null);

	        }
	        return response;
		}

		@Override
		public Response saveItemMaterials(JSONArray jsonString, int menuItemId) {
			Session session = null;
			
		        com.aptota.app.model.response.Response response = null;
		        
		        if (jsonString != null && !jsonString.equals("") && jsonString.length() > 0 && menuItemId !=0) {
		            try {
		            	   // System.out.println("1");
		                session = eneitymanager.unwrap(Session.class);
		                
		                for (int i = 0; i < jsonString.length(); i++) {
							JSONObject obj = jsonString.getJSONObject(i);

							int materialId = obj.getInt("materialId");
							double quantity = obj.getInt("quantity");
							
							
							
							 ItemMaterial itemMaterial = new ItemMaterial();
							 itemMaterial.setMaterialId(materialId);
							 itemMaterial.setQuantity(quantity);
							 itemMaterial.setItemId(menuItemId);
							 session.save(itemMaterial);
				             
						}
		               
		                response = new com.aptota.app.model.response.Response("SUCCESS", 200, "Item Saved successfully", menuItemId);


		            } catch (Exception e) {
		                response = new com.aptota.app.model.response.Response("FAILS", 300, "ERROR on Item registion ", menuItemId);
		                e.printStackTrace();
		               
		            } finally {


		                if (session != null && session.isOpen()) {

		                    session.close();

		                }
		            }
		        } else {
		            response = new com.aptota.app.model.response.Response("FAILS", 300, "Null Menu Item foud ", null);

		        }


		        return response;
		}

		@Override
		public Response getItemMaterials(int itemId) {
			Session session = null;
			
			List<GetItemMaterials> ItemMaterialList = new ArrayList<>();
			GetItemMaterials itemMaterials = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			Response response = null;
			String query = "select i.item_name, rm.name, rm.measurement_unit, im.quantity from item_material im " + 
					"join row_material rm on rm.idrow_material = im.material_id " +  
					"join item i on i.iditem = im.item_id " + 
					"where im.item_id = " + itemId;
			
			System.out.println("query is : " + query);
			try {
				session = eneitymanager.unwrap(Session.class);
				SessionImpl sessionImpl = (SessionImpl) session;
				connection = sessionImpl.connection();
				preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();
				List<GetItemMaterials> itemMaterialList = new ArrayList<GetItemMaterials>();
				System.out.println(rs);
				response = new Response("FAILS", 300, "Do not received any item material for given Item Id :  " + itemId , null);
				while (rs.next()) {
					
					GetItemMaterials getItemMaterials =new  GetItemMaterials();
					getItemMaterials.setItemName(rs.getString("item_name"));
					getItemMaterials.setMaterialName(rs.getString("name"));
					getItemMaterials.setMeasurementUnit(rs.getString("measurement_unit"));
					getItemMaterials.setQuantity(rs.getDouble("quantity"));
					
					itemMaterialList.add(getItemMaterials);
					
					response = new Response("SUCCESS", 200, "Received " + getItemMaterials.getItemName() + "Material List ", itemMaterialList);
				}
				
				
				
			}catch (Exception e) {
				response = new Response("FAILS", 300, "Error on getting Item Material list " + e.getMessage(), null);
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return response;
		}
	

	

	
	
	

}

package com.aptota.app.dao.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aptota.app.dao.CategoryDao;
import com.aptota.app.model.ItemType;
import com.aptota.app.model.response.Response;
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager eneitymanager;
	
	@Override
	public Response saveCategory(ItemType type) {
		Session session = null;
		Response response = null;
		
		
	try {
			session = eneitymanager.unwrap(Session.class);
			
			String itemTypeUpper = (type.getTypeName() != null && !type.getTypeName().isEmpty() && !type.getTypeName().equals("") && type.getTypeName().trim().length() > 0) ? type.getTypeName().toUpperCase().trim() : type.getTypeName();
			
			
			ItemType exsistingCategory = (ItemType) session.createCriteria(ItemType.class)
			.add(Restrictions.eq("typeName", type.getTypeName()))
			.uniqueResult();
			
			
			if (exsistingCategory == null) {
				session.save(type);
			    response = new Response("SUCCESS", 200, "Category registered successfully", type);
			
			} else {
				
				response = new Response("FAILS", 300, "Exsisting Category " , type);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		    response = new Response("FAILS", 300, "ERROR on Category registion " , e.getMessage());
		
		} finally {
			if(session != null && session.isOpen()) {
				
				session.close();
			}
		}
		return response;
	}

	@Override
	public List<ItemType> getAllCategoryTypes() {
		Session session = null;
		try {
			session = eneitymanager.unwrap(Session.class);
			 return session.createCriteria(ItemType.class)
			 .list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			
			if(session != null && session.isOpen()) {
				
				session.close();

		}
	}
	}

}

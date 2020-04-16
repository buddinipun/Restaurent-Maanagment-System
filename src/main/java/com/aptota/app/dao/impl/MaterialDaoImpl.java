package com.aptota.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aptota.app.dao.MaterialDao;
import com.aptota.app.model.ItemType;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;

@Repository
public class MaterialDaoImpl implements MaterialDao{
	
	@PersistenceContext
	private EntityManager eneitymanager;

	@Override
	public Response saveRowMaterial(RowMaterial material) {
		Session session = null;
		Response response = null;
		
		
	try {
			session = eneitymanager.unwrap(Session.class);
			System.out.println("1");
			System.out.println("Session is : " + session);
			String MaterialUpper = (material.getName()) != null && !material.getName().isEmpty() && !((material.getName().equals("")) && material.getName().trim().length() > 0) ? material.getName().toUpperCase().trim() : material.getName();
			
			
			ItemType exsistingItem = (ItemType) session.createCriteria(ItemType.class)
			.add(Restrictions.eq("typeName", material.getName()))
			.uniqueResult();
			
			
			if (exsistingItem == null) {
				System.out.println("2");
				session.save(material);
			    response = new Response("SUCCESS", 200, "Row Material registered successfully", material);
			
			} else {
				System.out.println("3");
				response = new Response("FAILS", 300, "Exsisting Row Material " , material);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Session is : " + session);
			System.out.println("4");
			System.out.println("error " + e.getMessage());
			e.printStackTrace();
		response = new Response("FAILS", 300, "ERROR on Row Material registion " , e.getMessage());
		
		} finally {
			System.out.println("5");
			if(session != null && session.isOpen()) {
				
				session.close();
			}
		}
		return response;
	}

	@Override
	public List<RowMaterial> getAllRowMaterials() {
		Session session = null;
		try {
			session = eneitymanager.unwrap(Session.class);
			 return session.createCriteria(RowMaterial.class)
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
//		}
	}
	}
	
	
	

}

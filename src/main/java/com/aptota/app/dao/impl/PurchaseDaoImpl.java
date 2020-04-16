package com.aptota.app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.aptota.app.dao.PurchaseDao;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public Response RowMaterialPurchase(RowMaterial rowMaterial) {
		
		Session session = null;
		Response response = null;
		int rowCount =0;
		double totalQuantity = 0d;
		
		response = gettotalQuantity(rowMaterial);
		
		if(response.getResCode() == 200) {
		
			totalQuantity = (Double)response.getResponse();
			
		try {
		
		String rowMaterialQuantityUpdateHQL = "update RowMaterial set totalQuantity = :totalQuantity where idrowMaterial = : materialId"; 
		session = entityManager.unwrap(Session.class);
		Transaction txn = session.beginTransaction();
		Query query = session.createQuery(rowMaterialQuantityUpdateHQL);	
		query.setDouble("totalQuantity", totalQuantity);
		query.setInteger("materialId", rowMaterial.getIdrowMaterial());
		rowCount = query.executeUpdate();
		txn.commit();
		
		
		if (rowCount >= 0) {
			response = new Response("SUCCESS", 200, "Row Material updated succesfully", totalQuantity);	
		} else {

			response = new Response("FAILS", 300, "ERROR ON Updating material total quantity : ", rowMaterial.getIdrowMaterial());	
			}
	    	
		} catch (Exception ex) {
			response = new Response("FAILS", 300, "ERROR ON Updating row_materials " + ex.getMessage(), totalQuantity);	
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				
				session.close();
			}
		}
			
		} 
		else {
			return response;
		}
		
		return response;
	}
	
	
public Response gettotalQuantity(RowMaterial rowMaterial) {
		
		Session session = null;
		Response response = null;
		Double totalQuantity = 0d;
		RowMaterial rowMaterial2 = null;
		
	if(rowMaterial != null) {
				totalQuantity = rowMaterial.getTotalQuantity();
			
			try {
				session = entityManager.unwrap(Session.class);	
				rowMaterial2 = (RowMaterial) session.createCriteria(RowMaterial.class)
						.add(Restrictions.eq("idrowMaterial",rowMaterial.getIdrowMaterial()))
						.uniqueResult();
				if(rowMaterial2 !=null) {
						
						if(rowMaterial2.getTotalQuantity() == null) {
								
							totalQuantity = rowMaterial.getTotalQuantity();
						}	
						else {
							totalQuantity = rowMaterial2.getTotalQuantity() + rowMaterial.getTotalQuantity();
						}
							response = new Response("SUCCESS", 200, "Got updated total quantity ", totalQuantity);	
					}else {
						   response = new Response("FAILS", 300, "No Row Material found for given ", totalQuantity);	
					}
				
			}catch (Exception e) {
				response = new Response("FAILS", 300, "Error on getting totalQUantiy : " + e.getMessage(), totalQuantity);	
			} 
	} else {
		
		response = new Response("FAILS", 300, "No Row_ Material found for updating ", totalQuantity);	
	}
		return response;
	}

}

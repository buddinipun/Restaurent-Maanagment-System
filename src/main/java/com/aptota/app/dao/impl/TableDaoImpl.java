package com.aptota.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aptota.app.dao.TableDao;
import com.aptota.app.model.RestaurentTable;
import com.aptota.app.model.response.Response;

@Repository
public class TableDaoImpl implements TableDao {

	@PersistenceContext
	private EntityManager eneitymanager;
	
	
	@Override
	public Response saveTable(RestaurentTable table) {
		
		Session session = null;
		Response response = null;
		
		
	try {
			session = eneitymanager.unwrap(Session.class);
			
			RestaurentTable exsistingTable = (RestaurentTable) session.createCriteria(RestaurentTable.class)
			.add(Restrictions.eq("tableName", table.getTableName()))
			.uniqueResult();
			
			
			if (exsistingTable == null) {
				session.save(table);
			    response = new Response("SUCCESS", 200, "Table registered successfully", table);
			
			} else {
				
				response = new Response("FAILS", 300, "Exsisting Table " , table);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		response = new Response("FAILS", 300, "ERROR on Table registion " , e.getMessage());
		
		} finally {
			if(session != null && session.isOpen()) {
				
				session.close();
			}
		}
		return response;
	}


	@Override
	public List<RestaurentTable> getAllTables() {
		Session session = null;
		try {
			 session = eneitymanager.unwrap(Session.class);
			 System.out.println("my session is : " + session );
			 return session.createCriteria(RestaurentTable.class)
			 .list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			
//			if(session != null && session.isOpen()) {
//				
//				session.close();
//			}
		}
	}
	
	

}

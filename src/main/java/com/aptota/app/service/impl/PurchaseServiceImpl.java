package com.aptota.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.PurchaseDao;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDao purchaseDao;
	@Override
	public Response RowMaterialPurchase(RowMaterial rowMaterial) {
		Response response = purchaseDao.RowMaterialPurchase(rowMaterial);
		return response;
	}
	
	

}

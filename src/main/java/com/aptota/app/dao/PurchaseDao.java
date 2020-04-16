package com.aptota.app.dao;

import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;

public interface PurchaseDao {
	
	public Response RowMaterialPurchase(RowMaterial rowMaterial);

}

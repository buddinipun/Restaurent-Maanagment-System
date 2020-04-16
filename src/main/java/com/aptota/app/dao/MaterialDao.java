package com.aptota.app.dao;

import java.util.List;

import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;

public interface MaterialDao {
	
	Response saveRowMaterial(RowMaterial material);
	List<RowMaterial> getAllRowMaterials();

}

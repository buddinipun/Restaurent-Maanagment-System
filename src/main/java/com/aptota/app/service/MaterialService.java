package com.aptota.app.service;

import java.util.List;

import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;

public interface MaterialService {

	public Response saveRowMaterial(RowMaterial material);
	public List<RowMaterial> getAllRowMatrials();
}

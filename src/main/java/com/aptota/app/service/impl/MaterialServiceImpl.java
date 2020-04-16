package com.aptota.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.ItemDao;
import com.aptota.app.dao.MaterialDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.RowMaterial;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.ItemService;
import com.aptota.app.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialDao materialdao;

	@Override
	public Response saveRowMaterial(RowMaterial material) {
		Response response = materialdao.saveRowMaterial(material);
		return response;
	}

	@Override
	public List<RowMaterial> getAllRowMatrials() {
		// TODO Auto-generated method stub
		return materialdao.getAllRowMaterials();
	}

}

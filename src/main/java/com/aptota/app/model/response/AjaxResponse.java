package com.aptota.app.model.response;

import java.util.List;

import com.aptota.app.model.Item;

public class AjaxResponse {

    private String resString;
    private boolean validated;
    private String message;
    private Response response;
    private List<GetItemMaterials> materials;
    private Item item;
   
    public AjaxResponse(String resString, boolean validated) {
        this.resString = resString;
        this.validated = validated;
    }
    
    
    
    public AjaxResponse(String resString, List<GetItemMaterials> materials) {
		super();
		this.resString = resString;
		this.materials = materials;
	}



	public AjaxResponse(String resString, Item item) {
		super();
		this.resString = resString;
		this.item = item;
	}



	public AjaxResponse(String message, Response response,boolean validated) {
		super();
		this.validated = validated;
		this.message = message;
		this.response = response;
	}
	public String getResString() {
        return resString;
    }

    public void setResString(String resString) {
        this.resString = resString;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}

	public List<GetItemMaterials> getMaterials() {
		return materials;
	}

	public void setMaterials(List<GetItemMaterials> materials) {
		this.materials = materials;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
  
    
}

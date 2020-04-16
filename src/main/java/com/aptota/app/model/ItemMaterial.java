package com.aptota.app.model;
// Generated Apr 11, 2020 9:22:27 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ItemMaterial generated by hbm2java
 */
@Entity
@Table(name = "item_material", catalog = "restaurent_erp")
public class ItemMaterial implements java.io.Serializable {

	private Integer iditemMaterial;
	private Integer materialId;
	private Double quantity;
	private Integer itemId;

	public ItemMaterial() {
	}

	public ItemMaterial(Integer materialId, Double quantity, Integer itemId) {
		this.materialId = materialId;
		this.quantity = quantity;
		this.itemId = itemId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iditem_material", unique = true, nullable = false)
	public Integer getIditemMaterial() {
		return this.iditemMaterial;
	}

	public void setIditemMaterial(Integer iditemMaterial) {
		this.iditemMaterial = iditemMaterial;
	}

	@Column(name = "material_id")
	public Integer getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	@Column(name = "quantity", length = 45)
	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Column(name = "item_id")
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

}

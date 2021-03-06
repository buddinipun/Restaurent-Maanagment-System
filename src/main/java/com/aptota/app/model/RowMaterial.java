package com.aptota.app.model;
// Generated Apr 11, 2020 9:22:27 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RowMaterial generated by hbm2java
 */
@Entity
@Table(name = "row_material", catalog = "restaurent_erp")
public class RowMaterial implements java.io.Serializable {

	private Integer idrowMaterial;
	private String name;
	private String code;
	private String type;
	private String description;
	private Integer minAmount;
	private String measurementUnit;
	private Double totalQuantity;

	public RowMaterial() {
	}

	public RowMaterial(String name, String code, String type, String description, Integer minAmount,
			String measurementUnit, Double totalQuantity) {
		this.name = name;
		this.code = code;
		this.type = type;
		this.description = description;
		this.minAmount = minAmount;
		this.measurementUnit = measurementUnit;
		this.totalQuantity = totalQuantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idrow_material", unique = true, nullable = false)
	public Integer getIdrowMaterial() {
		return this.idrowMaterial;
	}

	public void setIdrowMaterial(Integer idrowMaterial) {
		this.idrowMaterial = idrowMaterial;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "min_amount")
	public Integer getMinAmount() {
		return this.minAmount;
	}

	public void setMinAmount(Integer minAmount) {
		this.minAmount = minAmount;
	}

	@Column(name = "measurement_unit", length = 5)
	public String getMeasurementUnit() {
		return this.measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	@Column(name = "total_quantity", precision = 22, scale = 0)
	public Double getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}

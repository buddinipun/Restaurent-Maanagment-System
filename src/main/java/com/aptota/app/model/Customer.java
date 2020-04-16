package com.aptota.app.model;
// Generated Apr 11, 2020 9:22:27 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "restaurent_erp")
public class Customer implements java.io.Serializable {

	private Integer idcustomer;
	private String add1;
	private String add2;
	private String add3;
	private String contact1;
	private String contact2;
	private String customerName;
	private String description;
	private String email;
	private String nic;
	private String customerType;

	public Customer() {
	}

	public Customer(String add1, String add2, String add3, String contact1, String contact2, String customerName,
			String description, String email, String nic, String customerType) {
		this.add1 = add1;
		this.add2 = add2;
		this.add3 = add3;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.customerName = customerName;
		this.description = description;
		this.email = email;
		this.nic = nic;
		this.customerType = customerType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcustomer", unique = true, nullable = false)
	public Integer getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	@Column(name = "add1", length = 45)
	public String getAdd1() {
		return this.add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	@Column(name = "add2", length = 45)
	public String getAdd2() {
		return this.add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	@Column(name = "add3", length = 45)
	public String getAdd3() {
		return this.add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	@Column(name = "contact1", length = 45)
	public String getContact1() {
		return this.contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	@Column(name = "contact2", length = 45)
	public String getContact2() {
		return this.contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	@Column(name = "customer_name", length = 45)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "nic", length = 15)
	public String getNic() {
		return this.nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	@Column(name = "customer_type", length = 15)
	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}

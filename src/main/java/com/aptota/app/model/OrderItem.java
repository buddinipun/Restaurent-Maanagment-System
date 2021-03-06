package com.aptota.app.model;
// Generated Apr 11, 2020 9:22:27 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrderItem generated by hbm2java
 */
@Entity
@Table(name = "order_item", catalog = "restaurent_erp")
public class OrderItem implements java.io.Serializable {

	private Integer idmenuItem;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String orderStatus;
	private String orderItem;
	private Date orderReqTime;
	private Date kitchenReqTTme;
	private Date kitchenDeliveryTime;
	private String kitchenStatus;
	private Date orderDeliveryTime;
	private Integer orderId;
	private Integer quantity;

	public OrderItem() {
	}

	public OrderItem(String itemName, String itemType, String itemDescription, String orderStatus, String orderItem,
			Date orderReqTime, Date kitchenReqTTme, Date kitchenDeliveryTime, String kitchenStatus,
			Date orderDeliveryTime, Integer orderId, Integer quantity) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.orderStatus = orderStatus;
		this.orderItem = orderItem;
		this.orderReqTime = orderReqTime;
		this.kitchenReqTTme = kitchenReqTTme;
		this.kitchenDeliveryTime = kitchenDeliveryTime;
		this.kitchenStatus = kitchenStatus;
		this.orderDeliveryTime = orderDeliveryTime;
		this.orderId = orderId;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idmenu_item", unique = true, nullable = false)
	public Integer getIdmenuItem() {
		return this.idmenuItem;
	}

	public void setIdmenuItem(Integer idmenuItem) {
		this.idmenuItem = idmenuItem;
	}

	@Column(name = "item_name", length = 15)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_type", length = 10)
	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Column(name = "item_description", length = 45)
	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Column(name = "order_status", length = 15)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "order_item", length = 45)
	public String getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_req_time", length = 19)
	public Date getOrderReqTime() {
		return this.orderReqTime;
	}

	public void setOrderReqTime(Date orderReqTime) {
		this.orderReqTime = orderReqTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "kitchen_req_t_tme", length = 19)
	public Date getKitchenReqTTme() {
		return this.kitchenReqTTme;
	}

	public void setKitchenReqTTme(Date kitchenReqTTme) {
		this.kitchenReqTTme = kitchenReqTTme;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "kitchen_delivery_time", length = 19)
	public Date getKitchenDeliveryTime() {
		return this.kitchenDeliveryTime;
	}

	public void setKitchenDeliveryTime(Date kitchenDeliveryTime) {
		this.kitchenDeliveryTime = kitchenDeliveryTime;
	}

	@Column(name = "kitchen_status", length = 2)
	public String getKitchenStatus() {
		return this.kitchenStatus;
	}

	public void setKitchenStatus(String kitchenStatus) {
		this.kitchenStatus = kitchenStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_delivery_time", length = 19)
	public Date getOrderDeliveryTime() {
		return this.orderDeliveryTime;
	}

	public void setOrderDeliveryTime(Date orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}

	@Column(name = "order_id")
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

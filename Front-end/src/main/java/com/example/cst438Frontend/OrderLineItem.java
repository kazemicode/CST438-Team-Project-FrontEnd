package com.example.cst438Frontend;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

/* For accessing and saving to the order_line_items table in the foodflight schema */
/* To read: https://www.baeldung.com/jpa-mapping-single-entity-to-multiple-tables */
@Entity
@Table(name = "order_line_items")
public class OrderLineItem implements Serializable{
	@Id
	@Column(name = "order_sequence")
	private int orderSequence;
	@Column(name = "dish_id")
	private long dishId;
	private int qty;
	@Column(name = "line_item_amount")
	private double lineItemAmount;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "order_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Order order;

	
	public OrderLineItem() {
		this(0, 0, 0, 0);
	}


	public OrderLineItem(int orderSequence, long dishId, int qty, double lineItemAmount) {
		super();
		this.orderSequence = orderSequence;
		this.dishId = dishId;
		this.qty = qty;
		this.lineItemAmount = lineItemAmount;
	}


	public OrderLineItem(JSONObject oli) {
		this.orderSequence = 0;
		this.qty = oli.getInt("qty");
		this.dishId = oli.getLong("dishId");
		this.lineItemAmount = oli.getDouble("price");
	}


	public int getOrderSequence() {
		return orderSequence;
	}


	public void setOrderSequence(int orderSequence) {
		this.orderSequence = orderSequence;
	}


	public long getDishId() {
		return dishId;
	}


	public void setDishId(long dishId) {
		this.dishId = dishId;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public double getLineItemAmount() {
		return lineItemAmount;
	}


	public void setLineItemAmount(double lineItemAmount) {
		this.lineItemAmount = lineItemAmount;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "OrderLineItem [orderSequence=" + orderSequence + ", dishId=" + dishId + ", qty=" + qty
				+ ", lineItemAmount=" + lineItemAmount + "]";
	}
	

	
}

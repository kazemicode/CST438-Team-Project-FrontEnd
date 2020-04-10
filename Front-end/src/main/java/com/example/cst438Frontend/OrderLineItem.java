package com.example.cst438Frontend;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/* For accessing and saving to the order_line_items table in the foodflight schema */
/* To read: https://www.baeldung.com/jpa-mapping-single-entity-to-multiple-tables */
@Entity
@Table(name = "order_line_items")
@IdClass(OrderLineItemId.class)
public class OrderLineItem implements Serializable{
	@Id
	@Column(name = "order_id")
	private long orderId;
	@Id
	private int order_sequence;
	private long dish_id;
	private int qty;
	private double line_item_amount;
	
	public OrderLineItem() {
		this(0, 0, 0, 0, 0);
	}
	public OrderLineItem(long order_id, int order_sequence, long dish_id, int qty, double line_item_amount) {
		super();
		this.orderId = order_id;
		this.order_sequence = order_sequence;
		this.dish_id = dish_id;
		this.qty = qty;
		this.line_item_amount = line_item_amount;
	}
	public long getOrder_id() {
		return orderId;
	}
	public void setOrder_id(long order_id) {
		this.orderId = order_id;
	}
	public int getOrder_sequence() {
		return order_sequence;
	}
	public void setOrder_sequence(int order_sequence) {
		this.order_sequence = order_sequence;
	}
	public long getDish_id() {
		return dish_id;
	}
	public void setDish_id(long dish_id) {
		this.dish_id = dish_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getLine_item_amount() {
		return line_item_amount;
	}
	public void setLine_item_amount(double line_item_amount) {
		this.line_item_amount = line_item_amount;
	}
	
	
	
}

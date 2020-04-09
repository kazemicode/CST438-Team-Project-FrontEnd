package com.example.cst438Frontend;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* For accessing and saving to the orders table in the foodflight schema */

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private long id;
	private long cust_id;
	private Timestamp order_datetime;
	private double order_total;
	private double tip;
	private double grand_total;
	private String payment_type;
	
	public Order() {
		this(0, 0, new Timestamp(new Date().getTime()), 0, 0, 0, "payment");
	}
	public Order(long id, long cust_id, Timestamp order_datetime, double order_total, double tip, double grand_total,
			String payment_type) {
		super();
		this.id = id;
		this.cust_id = cust_id;
		this.order_datetime = order_datetime;
		this.order_total = order_total;
		this.tip = tip;
		this.grand_total = grand_total;
		this.payment_type = payment_type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCust_id() {
		return cust_id;
	}
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	public Timestamp getOrder_datetime() {
		return order_datetime;
	}
	public void setOrder_datetime(Timestamp order_datetime) {
		this.order_datetime = order_datetime;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	public double getTip() {
		return tip;
	}
	public void setTip(double tip) {
		this.tip = tip;
	}
	public double getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	
	
}

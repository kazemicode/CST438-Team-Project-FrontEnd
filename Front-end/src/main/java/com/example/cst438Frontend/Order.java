package com.example.cst438Frontend;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/* For accessing and saving to the orders table in the foodflight schema */

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private long id;
	@Column(name = "order_datetime")
	private Timestamp orderDatetime;
	@Column(name = "order_total")
	private double orderTotal;
	private double tip;
	@Column(name = "grand_total")
	private double grandTotal;
	@Column(name = "payment_type")
	private String paymentType;
	
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	@JsonBackReference
	private Customer customer; // parent class
	
	public Order() {
		this(new Timestamp(new Date().getTime()), 0, 0, 0, "payment");
	}

	public Order(Timestamp orderDatetime, double orderTotal, double tip, double grandTotal,
			String paymentType) {
		super();
		this.orderDatetime = orderDatetime;
		this.orderTotal = orderTotal;
		this.tip = tip;
		this.grandTotal = grandTotal;
		this.paymentType = paymentType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Timestamp getOrderDatetime() {
		return orderDatetime;
	}

	public void setOrderDatetime(Timestamp orderDatetime) {
		this.orderDatetime = orderDatetime;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		this.tip = tip;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(grandTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		temp = Double.doubleToLongBits(orderTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
		temp = Double.doubleToLongBits(tip);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (grandTotal != other.grandTotal)
			return false;
		if (id != other.id)
			return false;
		if (orderTotal != other.orderTotal)
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		if (tip != other.tip)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderDatetime=" + orderDatetime + ", orderTotal=" + orderTotal + ", tip=" + tip + ", grandTotal="
				+ grandTotal + ", paymentType=" + paymentType + "]";
	}
	
	

}

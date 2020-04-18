package com.example.cst438Frontend.domain;

import java.sql.Timestamp;
import java.util.List;

import com.example.cst438Frontend.*;


public class OrderInfo {
	
	private long orderId;
	private Timestamp datetime;
	private String custName; // Concatenated first/last from db
	private String phone;
	private String address; // concatenated address1, address2, city, state, zip from db
	private List<LineItemInfo> lineItems;
	private double total;
	private String paymentType;
	
	public OrderInfo(Order order, Customer customer, List<LineItemInfo> lineItems) {
		this.orderId = order.getId();
		this.datetime = order.getOrderDatetime();
		this.custName = customer.getFirstName() + " " + customer.getLastName();
		this.phone = customer.getPhone();
		this.address = customer.getAddress1() + " " + customer.getAddress2() + " " + customer.getCity() + " " + customer.getState() + " " + customer.getZipcode();
		this.lineItems = lineItems;
		this.total = order.getGrandTotal();
		this.paymentType = order.getPaymentType();
	}
	
	public OrderInfo(long orderId, Timestamp datetime, String custName, String phone, String address,
			List<LineItemInfo> lineItems, double total, String paymentType) {
		super();
		this.orderId = orderId;
		this.datetime = datetime;
		this.custName = custName;
		this.phone = phone;
		this.address = address;
		this.lineItems = lineItems;
		this.total = total;
		this.paymentType = paymentType;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<LineItemInfo> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemInfo> lineItems) {
		this.lineItems = lineItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", datetime=" + datetime + ", custName=" + custName + ", phone="
				+ phone + ", address=" + address + ", lineItems=" + lineItems + ", total=" + total + ", paymentType="
				+ paymentType + "]";
	}
	
	
	
	
	
	

}

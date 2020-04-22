package com.example.cst438Frontend.domain;

import com.example.cst438Frontend.*;


/* Helper class to provide details about each line item in an order to RabbitMQ */

public class LineItemInfo {
	
	private double price;
	private String name;
	private int qty;
	private long restId;
	
	public LineItemInfo() {
	
		
	}
	
	public LineItemInfo(MenuItem menuItem, OrderLineItem orderLineItem) {
		this.name = menuItem.getName();
		this.price = orderLineItem.getLineItemAmount();
		this.qty = orderLineItem.getQty();
		this.setRestId(menuItem.getRestId());
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}	
	
	
	@Override
	public String toString() {
		// Example: Rainbow Roll: $9.99 x 2
		return name + ": " + "$" + String.format("%.2f", price) + " x" + qty;
	}

	public long getRestId() {
		return restId;
	}

	public void setRestId(long restId) {
		this.restId = restId;
	}
}

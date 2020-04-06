package com.example.cst438Frontend;

/* Helper class to provide details about each line item in an order to RabbitMQ */

public class LineItem {
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

	private double price;
	private String name;
	private int qty;
	
	public LineItem() {
		this(0, "name", 0);
		
	}
	
	public LineItem(double price, String name, int qty) {
		this.price = price;
		this.name = name;
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		// Example: Rainbow Roll: $9.99 x 2
		return name + ": " + "$" + String.format("%.2f", price) + " x" + qty;
	}
}

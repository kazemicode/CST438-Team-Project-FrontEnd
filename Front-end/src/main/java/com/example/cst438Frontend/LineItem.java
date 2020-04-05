package com.example.cst438Frontend;

public class LineItem {
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

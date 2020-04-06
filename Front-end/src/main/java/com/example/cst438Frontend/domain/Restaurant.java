package com.example.cst438Frontend.domain;

public class Restaurant {
	
	public int id;
	public String name;
	public String address;
	public String phoneNumber;
	public String cuisine;
	
	public Restaurant(int id, String name, String address, String phoneNumber, String cuisine) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisine = cuisine;
	}
	
}

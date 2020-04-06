package com.example.cst438Frontend.domain;

import javax.persistence.Entity;

@Entity
public class Restaurant {

	
	private String name;
	private String address;
	private String phone;
	private String latitude;
	private String longitude;
	
	// menu object?
	
	public Restaurant() {
		
	}
	
	public Restaurant(String name, String address, String phone, String latitude, String longitude) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.latitude = latitude;
		this.longitude = longitude;
	}


}

package com.example.cst438Frontend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_items")
public class MenuItem {
	
	@Id
	@Column(name = "dish_id")
	private long id;
	@Column(name = "rest_id")
	private long restId;
	@Column(name = "dish_name")
	private String name;
	private String dish_type;
	private String dish_description;
	private double price;
	
	public MenuItem() {
		
	}
	
	public MenuItem(long id, long rest_id, String name, String dish_type, String dish_description, double price) {
		super();
		this.id = id;
		this.restId = rest_id;
		this.name = name;
		this.dish_type = dish_type;
		this.dish_description = dish_description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRest_id() {
		return restId;
	}

	public void setRest_id(long rest_id) {
		this.restId = rest_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDish_type() {
		return dish_type;
	}

	public void setDish_type(String dish_type) {
		this.dish_type = dish_type;
	}

	public String getDish_description() {
		return dish_description;
	}

	public void setDish_description(String dish_description) {
		this.dish_description = dish_description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}

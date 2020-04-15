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
	@Column(name = "dish_type")
	private String dishType;
	@Column(name = "dish_description")
	private String dishDescription;
	private double price;
	
	public MenuItem() {
		
	}
	
	public MenuItem(long id, long restId, String name, String dishType, String dishDescription, double price) {
		super();
		this.id = id;
		this.restId = restId;
		this.name = name;
		this.dishType = dishType;
		this.dishDescription = dishDescription;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRestId() {
		return restId;
	}

	public void setRestId(long restId) {
		this.restId = restId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishDescription == null) ? 0 : dishDescription.hashCode());
		result = prime * result + ((dishType == null) ? 0 : dishType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (restId ^ (restId >>> 32));
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
		MenuItem other = (MenuItem) obj;
		if (dishDescription == null) {
			if (other.dishDescription != null)
				return false;
		} else if (!dishDescription.equals(other.dishDescription))
			return false;
		if (dishType == null) {
			if (other.dishType != null)
				return false;
		} else if (!dishType.equals(other.dishType))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (restId != other.restId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", restId=" + restId + ", name=" + name + ", dishType=" + dishType
				+ ", dishDescription=" + dishDescription + ", price=" + price + "]";
	}
}
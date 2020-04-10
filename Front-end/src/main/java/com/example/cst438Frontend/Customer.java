package com.example.cst438Frontend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "cust_id")
	private long id;
	private String first_name;
	private String last_name;
	private String cust_address1;
	private String cust_address2;
	private String cust_city;
	private String cust_state;
	private String cust_zipcode;
	private String cust_phone;
	
	
	public Customer() {
		this(1, "first", "last", "address1", "address2", "city", "state", "00000", "000-000-0000");
	}
	
	public Customer(long id, String first_name, String last_name, String cust_address1, String cust_address2,
			String cust_city, String cust_state, String cust_zipcode, String cust_phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.cust_address1 = cust_address1;
		this.cust_address2 = cust_address2;
		this.cust_city = cust_city;
		this.cust_state = cust_state;
		this.cust_zipcode = cust_zipcode;
		this.cust_phone = cust_phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCust_address1() {
		return cust_address1;
	}

	public void setCust_address1(String cust_address1) {
		this.cust_address1 = cust_address1;
	}

	public String getCust_address2() {
		return cust_address2;
	}

	public void setCust_address2(String cust_address2) {
		this.cust_address2 = cust_address2;
	}

	public String getCust_city() {
		return cust_city;
	}

	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}

	public String getCust_state() {
		return cust_state;
	}

	public void setCust_state(String cust_state) {
		this.cust_state = cust_state;
	}

	public String getCust_zipcode() {
		return cust_zipcode;
	}

	public void setCust_zipcode(String cust_zipcode) {
		this.cust_zipcode = cust_zipcode;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	
	
	
	

}



package com.example.cst438Frontend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Session {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "cust_address1")
	private String addr1;
	@Column(name = "cust_address2")
	private String addr2;
	@Column(name = "cust_city")
	private String city;
	@Column(name = "cust_state")
	private String state;
	@Column(name = "cust_zip_code")
	private String zipcode;
	@Column(name = "cust_phone")
	private String phone;
	@Column(name = "order_total")
	private double subtotal;
	private double tip;
	@Column(name = "grand_total")
	private double grandtotal;
	@Column(name = "payment_type")
	private String paymentType;
	@Column(name = "order_line_items")
	private String orderLineItems;

	
	public Session()
	{
		firstName = "";
		lastName = "";
		addr1 = "";
		addr2 = "";
		city = "";
		state = "";
		zipcode = "";
		phone = "";
		paymentType= "";
		orderLineItems = "{}";
	}
		
	
	public Session(String firstName, String lastName, String addr1, String addr2, String city, String state,
			String zipcode, String phone, double subtotal, double tip, double grandtotal, String paymentType, String orderLineItems) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.subtotal = subtotal;
		this.tip = tip;
		this.grandtotal = grandtotal;
		this.paymentType = paymentType;
		this.orderLineItems = orderLineItems;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTip() {
		return tip;
	}
	public void setTip(double tip) {
		this.tip = tip;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public String getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(String orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}



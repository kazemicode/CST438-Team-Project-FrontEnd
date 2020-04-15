package com.example.cst438Frontend.domain;


public class User {

	private String address;
	private String address_2;
	private String city;
	private String state;
	private String zip_code;
	private String longitude;
	private String latitude;
	
	public User() {
		
	}
	
	public User(String address, String address_2, String city, String state, String zip_code) {
		this.address = address;
		this.setAddress_2(address_2);
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
	}
	
	public User(String longitude, String latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public void setCoordinates(String coordinates) {
		String[] c = coordinates.split(",");
		this.longitude = c[0];
		this.latitude = c[1];
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	
}

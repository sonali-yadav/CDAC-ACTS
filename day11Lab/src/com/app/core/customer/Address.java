package com.app.core.customer;

import java.io.Serializable;

//making this serializable so as to save in ser file

public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String city, state, country, phoneNo, type;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// default constructor
	public Address() {
		city = state = country = phoneNo = type = "";
	}

	// parameterized constructor
	public Address(String city, String state, String country, String phoneNo, String type) {
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.type = type;
	}

	// overriding to compare equality by type of address
	@Override
	public boolean equals(Object obj) {
		return (this.type).equals(((Address) obj).type);
	}

	@Override
	public String toString() {
		return type + ",\n" + city + ", " + state + ", \n" + country + ", \n Phone: " + phoneNo;
	}
}
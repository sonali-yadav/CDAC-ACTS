package com.app.core.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email, password;
	private double regAmount;
	private Date regDate;
	private CustType type;
	private ArrayList<Address> address;

	// default constructor
	public Customer() {
		email = password = "";
		regAmount = 0;
		regDate = new Date();
		address = new ArrayList<Address>();
	}

	// parameterized constructor
	public Customer(String email, String password, double regAmount, Date regDate, CustType type) {
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.type = type;
		address = new ArrayList<Address>();
	}

	// instance method to add an address for a customer
	public void linkAddress(String city, String state, String country, String phoneNo, String type) {
		address.add(new Address(city, state, country, phoneNo, type));
	}

	// overriding for custom display
	@Override
	public String toString() {
		return "email->" + email + " regAmount->" + regAmount + " regDate->" + regDate + " type->" + type
				+ " address-> ["
				//+ address.toArray(new Address[10])+"**"
				//+ address.toArray() + "**" 
				+ address.toString()+"]";
	}

	// overriding equals method to determine equality using email [pk here]
	@Override
	public boolean equals(Object obj) {
		return (this.email).equals(((Customer) obj).email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public CustType getType() {
		return type;
	}

	public ArrayList<Address> getAddress() {
		return address;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(CustType type) {
		this.type = type;
	}

	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}

	// method to update the address of a particular type
	public void updateAddress(String city, String state, String country, String phoneNo, String type) {
		for (Address a : address) {
			if ((a.getType()).equals(type)) {
				a.setCity(city);
				a.setState(state);
				a.setCountry(country);
				a.setPhoneNo(phoneNo);
			}
		}
	}
}

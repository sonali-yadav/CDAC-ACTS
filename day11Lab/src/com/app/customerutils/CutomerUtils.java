package com.app.customerutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.app.core.customer.Address;
import com.app.core.customer.CustType;
import com.app.core.customer.Customer;
import com.app.exceptions.CustomerHandlingException;

public class CutomerUtils {
	
	//method to populate the map with initial test data
	public static HashMap<String, Customer> populateCustomerHashMap() throws ParseException, IllegalArgumentException {
		HashMap<String, Customer> cmap = new HashMap<>();
		cmap.put("s@gmail",new Customer("s@gmail","123456", 4500, convertToDate("29-1-1994"), convertToCustType("PLATINUM")));
		cmap.put("sh@gmail",new Customer("sh@gmail","456123", 2500, convertToDate("25-12-1995"), convertToCustType("GOLD")));
		cmap.put("k@gmail",new Customer("k@gmail","112233", 3500, convertToDate("16-2-1998"), convertToCustType("PLATINUM")));
		cmap.put("ky@gmail",new Customer("ky@gmail","445566", 3000, convertToDate("28-11-1998"), convertToCustType("GOLD")));
		cmap.put("a@gmail",new Customer("a@gmail","010101", 1000, convertToDate("4-11-1996"), convertToCustType("SILVER")));
		return cmap;
	}

	// utility method to convert date(String)-->date(Date)
	public static Date convertToDate(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(d);
		return date;
	}

	// utility method to convert type(String) to CustType(Enum)
	public static CustType convertToCustType(String t) throws IllegalArgumentException {
		return CustType.valueOf(t.toUpperCase());
	}

	// utility method to find customer by email
	public static Customer findCustomer(String email, HashMap<String, Customer> cust) {
		return cust.get(email);
	}

	// utility method to verify the password for a customer
	public static boolean validateLogin(Customer c, String password) throws CustomerHandlingException {
		if (password.equals(c.getPassword()))
			return true;
		else
			throw new CustomerHandlingException("Could Not Verify Password!");
	}

	// utility method to check if the type of address chosen for update, exists
	public static boolean checkAddressType(Customer c, String t) throws CustomerHandlingException {
		Address ad = new Address();
		ad.setType(t);
		if ((c.getAddress()).contains(ad))
			return true;
		else
			throw new CustomerHandlingException("Address type not found! Kindly add a fresh address of this type!");
	}
}

package com.app.tester;

import java.io.IOException;
import java.io.InvalidClassException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.customer.CustType;
import com.app.core.customer.Customer;
import com.app.exceptions.CustomerHandlingException;

import static com.app.customerutils.CutomerUtils.*;
import static com.app.customerutils.IOUtils.*;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// initialize Data structure
			// HashMap<String, Customer> customers = new HashMap<>();
			HashMap<String, Customer> customers=null;
			try {
				//changing this method from CustomerUtils to IOUtils to load the saved data from a binary file
				//customers = populateCustomerHashMap(); //was throwing ParseExcep, IllegalArgExcep
				customers = populateCustomerHashMapFromFile();
			}catch (ParseException e) {
				e.printStackTrace();
			} catch (InvalidClassException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Options: 1.Register new customer\n"
							+ "2.Link an address to an existing customer\n" 
							+ "3.Customer Login\n"
							+ "4.Unsubscribe Customer\n" 
							+ "5.Display all customers by type\n"
							+ "6.Update an existing address for a customer\n" 
							+ "7.Sort customers by email\n"
							+ "8.Sort customers by registration date\n" 
							+ "9.View All Current Customers\n" 
							+ "0. Exit");
					System.out.println("Enter your option:");
					switch (sc.nextInt()) {
					case 1: // register a new customer
						try {
							System.out.println("Enter new customer details in format: "
									+ "email password regAmount regDate customerType");
							String em = sc.next();
							Customer customer = new Customer(em, sc.next(), sc.nextDouble(), convertToDate(sc.next()),
									convertToCustType(sc.next()));

							// adding to our hash map
							customers.put(em, customer);

							// DISPLAY DETAILS IF INSTANCE ADDED SUCCESSFULLY
							System.out.println(customer);
						} catch (ParseException e1) {
							System.out.println(e1);
						} catch (IllegalArgumentException e2) {
							System.out.println(e2);
						}
						break;
					case 2: // Link an address to an existing customer
						System.out.println("You must login to add an address!");
						System.out.println("Enter Login details in format: email password");
						Customer c = findCustomer(sc.next(), customers);
						try {
							if (validateLogin(c, sc.next())) {
								System.out.println("Login successfully verified!");
								System.out.println("Enter the address to add in format: city state country phoneNo type");
								c.linkAddress(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
								// DISPLAY DETAILS IF INSTANCE ADDED SUCCESSFULLY
								System.out.println(c);
							}
						} catch (CustomerHandlingException e) {
							System.out.println(e);
						}
						break;
					case 3:// Customer Login
						System.out.println("Enter Login details in format: email password");
						Customer c1 = findCustomer(sc.next(), customers);
						try {
							if (validateLogin(c1, sc.next())) {
								System.out.println("Login successfully verified!");
								// DISPLAY DETAILS IF LOGIN SUCCESSFUL
								System.out.println(c1);
							}
						} catch (CustomerHandlingException e) {
							System.out.println(e);
						}
						break;
					case 4: // Unsubscribe Customer
						System.out.println("Enter Login details in format: email password");
						String em1 = sc.next();
						Customer c2 = findCustomer(em1, customers);
						try {
							if (validateLogin(c2, sc.next())) {
								System.out.println("Login successfully verified!");
								Customer s = customers.remove(em1);
								System.out.println(
										s != null ? "Successfully Unsubscribed..." : "Could Not Unsubscribe...");
							}
						} catch (CustomerHandlingException e) {
							System.out.println(e);
						}
						break;
					case 5: // Display all customers by type
						System.out.println("Enter type of customer[SILVER, GOLD, PLATINUM] to display: ");
						String t = sc.next();
						try {
							// IMP: COLLECTION VIEW EXAMPLE
							for (Entry<String, Customer> cust : customers.entrySet()) {
								if ((cust.getValue().getType()).equals(CustType.valueOf(t)))
									System.out.println(cust.getValue());
							}
							// wrote this code for array list, later changed to hash map
							/*
							 * for (Customer cust : customers) { if
							 * ((cust.getType()).equals(CustType.valueOf(t))) { System.out.println(cust); }
							 * }
							 */
							System.out.println("end of list.");
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}
						break;
					case 6: // Update an existing address for a customer
						System.out.println("You must login to update an address!");
						System.out.println("Enter Login details in format: email password");
						Customer c3 = findCustomer(sc.next(), customers);
						try {
							if (validateLogin(c3, sc.next())) {
								System.out.println("Login successfully verified! Your current details are: ");
								System.out.println(c3);
								System.out.println("Enter the type of the address you want to update:");
								String t1 = sc.next();
								if (checkAddressType(c3, t1)) {
									System.out.println("Enter the new address in format: city state country phoneNo");
									c3.updateAddress(sc.next(), sc.next(), sc.next(), sc.next(), t1);
									System.out.println("Update Successful!");
									System.out.println(c3);
								}
							}
						} catch (CustomerHandlingException e) {
							System.out.println(e);
						}
						break;
					case 7: // Sort customers by email
						// IMP: NATURAL ORDERING AND TREEMAP EXAMPLE
						TreeMap<String, Customer> tm = new TreeMap<>(customers);
						for (Customer ct : tm.values()) {
							System.out.println(ct);
						}
						break;
					case 8: // Sort customers by registration date
						// IMP: CUSTOM ORDERING, COMPARATOR, ANONYMOUS CLASS EXAMPLE
						// V.IMP: THIS CREATES AN EMPTY MAP ONLY! WE HAVE ONLY GIVEN COMPARATOR, NOT ITEMS!
						// IT'S A FAMOUS INTERVIEW QUESTION.
						ArrayList<Customer> al=new ArrayList<Customer>(customers.values());
						// using al reason: because we want value based comparison, not key based
						Collections.sort(al, new Comparator<Customer>() {
							@Override
							public int compare(Customer c1, Customer c2) {
								return (c2.getRegDate()).compareTo(c1.getRegDate());
							}
						});
						for (Customer ct : al) {
							System.out.println(ct);
						}
						break;
					case 9: //view all current customers
						for (Customer cust : customers.values()) {
							System.out.println(cust);
						}
						break;
					case 0:	//save all the data into a binary file and then exit
						saveCustomerHashMapToFile(customers);
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}

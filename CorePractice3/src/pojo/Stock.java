package pojo;

import java.sql.Date;

public class Stock {

	private static int counter;
	private int id,quantity;
	private String name,company;
	private double price;
	private Date closingDate;
	
	public Stock() {
		id=++counter;
	}

	public Stock(int id, int quantity, String name, String company, double price, Date closingDate) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.name = name;
		this.company = company;
		this.price = price;
		this.closingDate = closingDate;
	}

	public Stock(int quantity, String name, String company, double price, Date closingDate) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.company = company;
		this.price = price;
		this.closingDate = closingDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", quantity=" + quantity + ", name=" + name + ", company=" + company + ", price="
				+ price + ", closingDate=" + closingDate + "]";
	}
	
	
}

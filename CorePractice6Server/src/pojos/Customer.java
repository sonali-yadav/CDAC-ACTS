package pojos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public class Customer {
	private String name, mobile;
	private LocalDate dob;
	private HashMap<Month, Bill> bills;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String mobile, LocalDate dob, HashMap<Month, Bill> bills) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.dob = dob;
		this.bills = bills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public HashMap<Month, Bill> getBills() {
		return bills;
	}

	public void setBills(HashMap<Month, Bill> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + ", dob=" + dob + ", bills=" + bills + "]";
	}
	
}

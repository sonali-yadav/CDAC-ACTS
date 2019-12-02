package pojos;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>, Serializable{
	private String email, password, address, mobile;
	private LocalDate dob;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String email, String password, String address, String mobile, LocalDate dob) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "Customer [email=" + email + ", password=" + password + ", address=" + address + ", mobile=" + mobile
				+ ", dob=" + dob + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return dob.compareTo(o.getDob());
	}
}

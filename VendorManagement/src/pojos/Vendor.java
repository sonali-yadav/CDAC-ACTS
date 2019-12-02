package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_master")
public class Vendor {

	// DATA MEMBERS
	private Integer id;
	private String name, email, password, city, phone;
	private double regAmount;
	private LocalDate regDate;

	public Vendor() {
		System.out.println("in def ctor of Vendor");
	}
	
	public Vendor(String name, String email, String password, String city, String phone, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phone = phone;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	// GETTERS AND SETTERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_pk")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "vendor_name", length=40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "vendor_email", length=30, unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "vendor_password", length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "vendor_city", length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "vendor_phone", length=10)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "vendor_regamount")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Column(name = "vendor_regdate")
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return id+" "+name+" "+email+" "+password+" "+city+" "+phone+" "+regAmount+" "+regDate;

	}
}

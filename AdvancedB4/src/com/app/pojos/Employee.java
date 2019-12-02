package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	private static int counter;
	private int empId;
	private String name, email, role;
	private LocalDate joinDate;
	private boolean isPermanent;

	public Employee() {
		super();
		empId=++counter;
		System.out.println("inside customer pojo");
	}

	public Employee(int empId, String name, String email, String role, LocalDate joinDate, boolean isPermanent) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.role = role;
		this.joinDate = joinDate;
		this.isPermanent = isPermanent;
	}

	public Employee(String name, String email, String role, LocalDate joinDate, boolean isPermanent) {
		super();
		empId=++counter;
		this.name = name;
		this.email = email;
		this.role = role;
		this.joinDate = joinDate;
		this.isPermanent = isPermanent;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(unique = true, length = 20)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
}
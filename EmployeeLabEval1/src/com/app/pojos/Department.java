package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Department {

	private String deptName, location;
	private int strength;
	private int id;
	private List<Employee> emps = new ArrayList<>();

	public Department() {
		System.out.println("inside Department() ctor");
	}

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Column(length = 30, unique = true)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(columnDefinition = "int default 0")
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//HELPER METHODS FOR HIRING AND FIRING EMPLOYEES
	
	public void hireEmployee(Employee e) {
		emps.add(e);
		strength=strength+1;
		e.setDepartment(this);
	}
	
	public void fireEmployee(Employee e) {
		emps.remove(e);
		e.setDepartment(null);
	}
}
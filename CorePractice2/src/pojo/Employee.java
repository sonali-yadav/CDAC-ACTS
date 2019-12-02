package pojo;

import java.time.LocalDate;

public class Employee  { //implements Comparable<Employee>{

	private static int counter;
	private int id;
	private String name, department;
	private LocalDate dob, hireDate;
	private double salary;

	public Employee() {
		super();
		id = ++counter;
	}

	public Employee(String name, String department, LocalDate dob, LocalDate hireDate, double salary) {
		super();
		id=++counter;
		this.name = name;
		this.department = department;
		this.dob = dob;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	public Employee(int id, String name, String department, LocalDate dob, LocalDate hireDate, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.dob = dob;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", dob=" + dob + ", hireDate="
				+ hireDate + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			return (this.id==((Employee)obj).getId());
		}
		return false;
	}
	
//	@Override
//	public int compareTo(Employee o) {
//		return (this.hireDate).compareTo(o.getHireDate());
//	}
	
}
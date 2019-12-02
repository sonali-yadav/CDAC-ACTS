package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_master")
public class Employee extends AbstractEntity {

	@Column(length = 30, unique = true)
	private String name;
	private double salary;

	@ManyToOne(fetch = FetchType.EAGER) // mandatory, else MappingException
	@JoinColumn(name = "department_id")
	private Department dept;

	public Employee() {
		System.out.println("in def ctor: Employee");
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", Id=" + getId() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee e = (Employee)obj;
			if(getId().equals(e.getId()))
				return true;
		}
		return false;
	}
}

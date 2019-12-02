package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department_master")
public class Department extends AbstractEntity {

	@Column(length = 20, unique = true)
	private String name;
	@Column(length = 20)
	private String location;
	// use interfaces on lhs only, and not any impl class --mandatory
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Employee> emps = new ArrayList<>();

	public Department() {
		System.out.println("In def ctor: Department");
	}

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + ", Id=" + getId() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	//HELPER/UTILITY METHODS FOR BI DIRECTIONAL RELATIONSHIP MANAGEMENT
	public void addEmployee(Employee e) {
		emps.add(e);		//Dept->Emp
		e.setDept(this);	//Emp->Dept
	}
	
	//this method is going by Employee reference equality, so we need to override the equals in Emp
	public void removeEmployee(Employee e) {
		emps.remove(e);		//Dept->Emp
		e.setDept(null);	//Emp->Dept
	}
}
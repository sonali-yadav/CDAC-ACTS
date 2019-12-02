package testers;

import java.util.Scanner;
import static utils.HibernateUtils.*;
import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;
import pojos.Department;
import pojos.Employee;

public class CreateNewDeptDepartmentTester {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getSf();) {
			System.out.println("Enter dept details: name, location");
			Department d=new Department(sc.next(),sc.next());
			for (int i = 0; i < 3; i++) {
				System.out.println("enter employee details: name,salary");
				d.addEmployee(new Employee(sc.next(),sc.nextDouble()));
			}
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println(dao.createNewDeptDepartment(d));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

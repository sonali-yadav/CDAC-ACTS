package testers;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;
import pojos.Employee;

public class HireEmpTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {
			System.out.println("Enter deptID empName empSalary");
			DepartmentDaoImpl dao = new DepartmentDaoImpl();
			System.out.println(dao.hireEmp(sc.nextInt(), new Employee(sc.next(), sc.nextDouble())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

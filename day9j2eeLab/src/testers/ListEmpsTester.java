package testers;

import static utils.HibernateUtils.getSf;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;
import pojos.Employee;

public class ListEmpsTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {
			System.out.println("Enter dept name to see all employees:");
			DepartmentDaoImpl dao = new DepartmentDaoImpl();
			List<Employee> ls=dao.listEmps(sc.next());
			for (Employee employee : ls) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

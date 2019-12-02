package testers;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;

public class FireEmpTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {
			System.out.println("Enter deptID and empID :");
			DepartmentDaoImpl dao = new DepartmentDaoImpl();
			System.out.println(dao.fireEmp(sc.nextInt(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

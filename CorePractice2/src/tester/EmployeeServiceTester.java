package tester;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import custexception.EmployeeHandlingException;
import pojo.Employee;
import static utils.CollectionUtils.*;;

public class EmployeeServiceTester {

	public static void main(String[] args) {
		int choice = 0;
		ArrayList<Employee> employees = new ArrayList<>();
		try (Scanner sc = new Scanner(System.in);) {
			do {
				System.out.println("***MENU***");
				System.out.println("1. Add Employee: name, dob, hireDate, salary and department");
				System.out.println("2. View Employee by ID");
				System.out.println("3. View Employees in ascending order with respect to date of joining.");
				System.out.println("4. Delete Employee by ID");
				System.out.println("0. Exit");
				System.out.println("Enter Choice: ");
				choice = sc.nextInt();

				switch (choice) {
				case 1: // 1. Add Employee: id(unique), name, dob, hireDate, salary and department
					System.out
							.println("enter emp name, department, dob [yyyy-MM-dd], hireDate [yyyy-MM-dd] and salary");
					employees.add(new Employee(sc.next(), sc.next(),LocalDate.parse(sc.next()),
							LocalDate.parse(sc.next()), sc.nextDouble()));
					System.out.println("Successfully added employee.");
					break;
				case 2: // 2. View Employee by ID
					System.out.println("Enter employee ID");
					System.out.println(getEmployeeById(sc.nextInt(), employees));
					break;
				case 3: // 3. View Employees in ascending order with respect to date of joining.
					Collections.sort(employees, new Comparator<Employee>() {

						@Override
						public int compare(Employee o1, Employee o2) {
							return o1.getHireDate().compareTo(o2.getHireDate());
						}
					});
//					Collections.sort(employees);
					for (Employee employee : employees) {
						System.out.println(employee);
					}
					break;
				case 4: // 4. Delete Employee by ID
					System.out.println("Enter id to delete:");
					Employee e = deleteEmployeeById(sc.nextInt(), employees);
					System.out.println("Delete Successful. Deleted Employee is:");
					System.out.println(e);
					break;
				default:
					break;
				}
			} while (choice != 0);
		} catch (DateTimeParseException e) {
			System.out.println(e);
		} catch (EmployeeHandlingException ex) {
			System.out.println(ex);
		}
	}
}

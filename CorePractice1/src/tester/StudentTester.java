package tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import custexception.StudentHandlingException;
import daos.StudentDaoImpl;
import pojos.Student;

public class StudentTester {

	public static void main(String[] args) {
		int choice = 0;
		List<Student> students = null;
		try (Scanner sc = new Scanner(System.in);) {
			StudentDaoImpl sdao = new StudentDaoImpl();
			do {
				System.out.println("****MENU****");
				System.out.println("1. Display All students by the specified course name");
				System.out.println("2. Update Student details (update marks & phone number)");
				System.out.println("3. Cancel Student admission");
				System.out.println("0. Exit");
				System.out.println("Enter your choice:");
				choice = sc.nextInt();
				switch (choice) {
				case 1: // 1. Display All students by the specified course name
					System.out.println("Enter the course name:");
					String cName = sc.next();
					students = sdao.getStudentsByCourse(cName);
					for (Student student : students) {
						System.out.println(student);
					}
					break;
				case 2: // 2. Update Student details (update marks & phone number)
					System.out.println("Enter student ID, new marks & new phone number:");
					System.out.println(sdao.updateStudentDetails(sc.nextInt(), sc.nextDouble(), sc.next()));
					break;
				case 3: // 3. Cancel Student admission
					System.out.println("Enter student email to cancel admission:");
					System.out.println(sdao.cancelStudentAdmission(sc.next())?"Delete Successful":"Could not delete");
					break;
				case 0: 
					break;
				default:
					break;
				}
			} while (choice != 0);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (StudentHandlingException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

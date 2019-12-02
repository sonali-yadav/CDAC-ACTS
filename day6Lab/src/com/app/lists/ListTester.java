package com.app.lists;

import static com.app.utils.ValidationRules.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import com.app.core.Student;
import com.app.cust_excs.StudentHandlingException;

public class ListTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// initialize Data structure
			ArrayList<Student> st = new ArrayList<>();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println(
							"Options: 1.Register new student\n" +
					"2.Display all students' info\n" + "3. Exit ");
					System.out.println("Enter your option:");
					switch (sc.nextInt()) {
					case 1: // register a new student
						try {
							System.out.println("Enter new student details in format prn name email course marks:");
							Student s = new Student(validatePrn(sc.next(), st), validateName(sc.next()),
									validateEmail(sc.next()), validateCourse(sc.next()), sc.nextInt(),
									validateDob(sc.next()));

							st.add(s);
							// DISPLAY DETAILS IF INSTANCE ADDED SUCCESSFULLY
							System.out.println(s);
						} catch (StudentHandlingException e) {
							System.out.println(e);
						} catch (ParseException e1) {
							System.out.println(e1);
						} catch (IllegalArgumentException e2) {
							System.out.println(e2);
						}
						break;
					case 2: // display all students
						for (Student student : st) {
							System.out.println(student);
						}
						break;
					case 3:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

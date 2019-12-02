package com.app.testers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.app.core.CourseType;
import com.app.core.Student;
import com.app.cust_excs.StudentHandlingException;
import static com.app.utils.ValidationRules.*;

public class Tester {
	public static void main(String[] args) {

		Student s;
		Date d1 = null, d2 = null, d3 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			d1 = sdf.parse("29/1/1994");
			d2 = sdf.parse("25/12/1995");
			d3 = sdf.parse("16/2/1998");
		} catch (ParseException e1) {
			System.out.println(e1);
		}
		// CREATING THE SAMPLE DATA IN ARRAY
		Student[] st = { new Student("001", "Sonali", "s@gmail.com", CourseType.valueOf("DAC"), 55, d1),
				new Student("002", "Shrushti", "sh@gmail.com", CourseType.valueOf("DAC"), 52, d2),
				new Student("003", "Ketki", "k@gmail.com", CourseType.valueOf("DAC"), 52, d3) };

		// TRY WITH RESOURCES BLOCK TO ADD A NEW STUDENT
		try (Scanner sc = new Scanner(System.in);) {

			// READING A STUDENT FROM USER
			System.out.println("Enter new student details in format prn name email course marks:");
			s = new Student(validatePrn(sc.next(), st), validateName(sc.next()), validateEmail(sc.next()),
					validateCourse(sc.next()), sc.nextInt(), validateDob(sc.next()));

			// DISPLAY DETAILS IF INSTANCE CREATED SUCCESSFULLY
			System.out.println(s);
		} catch (StudentHandlingException e) {
			System.out.println(e);
		} catch (ParseException e1) {
			System.out.println(e1);
		} catch (IllegalArgumentException e2) {
			System.out.println(e2);
		}

		// DISPLAY ALL STUDENTS USING THE FOR EACH LOOP
		for (Student student : st) {
			System.out.println(student);
		}
	}
}

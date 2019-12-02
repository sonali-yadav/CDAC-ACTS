package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.app.core.CourseType;
import com.app.core.Student;
import com.app.cust_excs.StudentHandlingException;

public class ValidationRules {

	// PRN VALIDATION RULE : MUST BE UNIQUE, MUST NOT ALREADY EXIST IN ST (ARRAY)
	public static String validatePrn(String prn, Student[] st) throws StudentHandlingException {
		Student temp = new Student();
		temp.setPrn(prn);
		for (Student s : st) {
			if (s.equals(temp))
				throw new StudentHandlingException("This PRN already Exists!");
		}
		return prn;
	}

	// OVERLOADED FUNCTION
	// PRN VALIDATION RULE : MUST BE UNIQUE, MUST NOT ALREADY EXIST IN ST
	// (ArrayList)
	public static String validatePrn(String prn, ArrayList<Student> st) throws StudentHandlingException {
		Student temp = new Student();
		temp.setPrn(prn);
		for (Student s : st) {
			if (s.equals(temp))
				throw new StudentHandlingException("This PRN already Exists!");
			;
		}
		return prn;
	}

	// OVERLOADED FUNCTION
	// PRN VALIDATION RULE : MUST BE UNIQUE, MUST NOT ALREADY EXIST IN ST (HashMap)--just for fun
	public static String validatePrn(String prn, HashMap<String, Student> st) throws StudentHandlingException {
		if (st.containsKey(prn)) {
			throw new StudentHandlingException("This PRN already Exists!");
		}
		return prn;
	}

	// NAME VALIDATION RULE: MUST BE MIN 4 CHARS & MAX 10 CHARS LONG
	public static String validateName(String name) throws StudentHandlingException {
		if (!(name.length() >= 4 && name.length() <= 10))
			throw new StudentHandlingException("Name must have 4 to 10 characters only!");
		return name;
	}

	// EMAIL VALIDATION RULE: MUST BE MIN 4 CHARS & MAX 10 CHARS LONG
	// AND MUST CONTAIN @
	public static String validateEmail(String email) throws StudentHandlingException {
		if (!(email.length() >= 4 && email.length() <= 10 && email.contains("@")))
			throw new StudentHandlingException("Email must have 4 to 10 characters only and @ character!");
		return email;
	}

	// COURSE VALIDATION RULE: MUST BE IN (DAC/DMC/DBDAC/DAI)
	public static CourseType validateCourse(String course) throws IllegalArgumentException {
//		if (!(course.toUpperCase().equals("DAC") || course.toUpperCase().equals("DMC")
//				|| course.toUpperCase().equals("DBDA") || course.toUpperCase().equals("DAI")))
//			throw new StudentHandlingException("Invalid Course! Must be one of DAC/DMC/DBDAC/DAI");

		return CourseType.valueOf(course.toUpperCase());
	}

	// DOB VALIDATION RULE: CAN'T BE BEFORE 1ST JAN 1985
	public static Date validateDob(String dob) throws StudentHandlingException, ParseException {
		Date d = (new SimpleDateFormat("dd/mm/yyyy")).parse(dob);
		if (d.compareTo(((new SimpleDateFormat("dd/mm/yyyy")).parse("1/1/1985"))) < 0) {
			throw new StudentHandlingException("DOB should be after 1/1/1985");
		}
		return d;
	}
}

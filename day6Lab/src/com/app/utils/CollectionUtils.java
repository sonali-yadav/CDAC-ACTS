package com.app.utils;

import static com.app.utils.ValidationRules.*;
import java.util.ArrayList;

import com.app.core.CourseType;
import com.app.core.Student;
import com.app.cust_excs.StudentHandlingException;

public class CollectionUtils {
	
	//UTILITY TO ADD SAMPLE DATA
	public static ArrayList<Student> populateStudents() {
		ArrayList<Student> al=new ArrayList<>();
		try {
			al.add(new Student(validatePrn("001",al), validateName("Sonali"), validateEmail("s@gmail.com"), validateCourse("DAC"), 55, validateDob("29/1/1994")));
			al.add(new Student(validatePrn("002",al), validateName("Shrushti"), validateEmail("sh@gmail.com"), validateCourse("DAC"), 52, validateDob("25/12/1995")));
			al.add(new Student(validatePrn("003",al), validateName("Ketki"), validateEmail("k@gmail.com"), validateCourse("DAC"), 52, validateDob("16/2/1998")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
	//UTILITY TO FIND A STUDENT BY PRN
	public static Student findStudent(String prn,ArrayList<Student> st) throws StudentHandlingException {
		for(Student s: st) {
			if(s.getPrn().equals(prn)) {
				return s;
			}
		}
		throw new StudentHandlingException("Student doesn't exist!");
	}
	
	
	//UTILITY TO UPDATE MARKS FOR A STUDENT BY PRN
	public static Student updateMarksByPRN(String prn, int marks, ArrayList<Student> st) throws StudentHandlingException{
		Student ss=findStudent(prn, st);
		ss.setMarks(marks);
		return ss;
	}
	
	//UTILITY TO RETURN A LIST OF STUDENTS OF A PARTICULAR COURSE
	public static ArrayList<Student> findStudentsByCourse(CourseType course, ArrayList<Student> st) {
		ArrayList<Student> sList=new ArrayList<>();
		for (Student student : st) {
			if(student.getCourse().equals(course))
				sList.add(student);
		}
		return sList;
	}
}

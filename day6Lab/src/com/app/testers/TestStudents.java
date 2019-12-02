package com.app.testers;

import static com.app.utils.ValidationRules.*;
import static com.app.utils.CollectionUtils.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import com.app.core.Student;
import com.app.cust_excs.StudentHandlingException;

public class TestStudents {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// initialize Data structure
			ArrayList<Student> st = new ArrayList<>();
			ArrayList<Student> sList = null;
			Student stud;
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Options: 1.Register new student\n" + "2.Display all students in a course\n"
							+ "3.Update student marks by PRN\n"
							+ "4.Show students for a course born after a specific date\n" + "5.Cancel Admission\n"
							+ "6.Sort by PRN --natural ordering\n"
							+ "7.Sort students as per dob & marks --custom ordering\n"
							+ "8.Show topper name for a course\n" + "0. Exit");
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
					case 2: // display all students by course
						System.out.println("Enter the course-name: ");
						String cname = sc.next();
						sList = findStudentsByCourse(validateCourse(cname), st);
						if (sList.size() > 0) {
							for (Student student : sList) {
								System.out.println(student);
							}
						} else
							System.out.println("No Students Currently Enrolled In This Course!");
						break;
					case 3: // Update student marks by PRN
						System.out.println("Enter the PRN: ");
						String prno = sc.next();
						System.out.println("Enter new marks: ");
						int marks = sc.nextInt();
						Student s3 = updateMarksByPRN(prno, marks, st);
						System.out.println(s3);
						break;
					case 4: // Show students for a course born after a specific date
						System.out.println("Enter the course-name: ");
						String cname4 = sc.next();
						System.out.println("Enter the date in dd-mm-yyyy format: ");
						String bornDate = sc.next();
						sList = findStudentsByCourse(validateCourse(cname4), st);
						for (Student student : sList) {
							if (student.getDob().after(validateDob(bornDate))) {
								System.out.println(student);
							}
						}
						break;
					case 5: // Cancel Admission
						System.out.println("Enter the PRN to cancel admission: ");
						String prno5 = sc.next();
						stud = new Student();
						stud.setPrn(prno5);
						if (st.contains(stud)) {
							st.remove(stud);
							System.out.println("Student removed successfully!");
						}
						break;
					case 6: // Sort by PRN --natural ordering
						Collections.sort(st);
						for (Student student : st) {
							System.out.println(student);
						}
						break;
					case 7: // Sort students as per dob & marks --custom ordering
							// HERE WE WILL BE USING THE CUSTOM COMPARATOR CLASS
							// ALSO WILL BE USING ANONYMOUS INNER CLASS FOR THIS
						System.out.println("Sort as per 1. DOB 2. MARKS...choose any one:");
						int ch = sc.nextInt();
						if (ch == 1) {
							Collections.sort(st, new Comparator<Student>() {
								@Override
								public int compare(Student s1, Student s2) {
									return ((s1.getDob()).compareTo(s2.getDob()));
								}
							});
						} else {
							Collections.sort(st, new Comparator<Student>() {
								@Override
								public int compare(Student s1, Student s2) {
									return (((Integer)s1.getMarks()).compareTo((Integer)s2.getMarks()));
								}
							});
						}
						break;
					case 8: // Show topper name for a course
						System.out.println("Enter the course-name: ");
						String cname8 = sc.next();
						sList = findStudentsByCourse(validateCourse(cname8), st);
						Collections.sort(st, new Comparator<Student>() {
							@Override
							public int compare(Student s1, Student s2) {
								return (((Integer)s1.getMarks()).compareTo((Integer)s2.getMarks()));
							}
						});
						System.out.println(sList.get(sList.size()-1));
						break;
					case 0:
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

package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pojo.Student;

public class StudentTester {

	public static void main(String[] args) {
		ArrayList<Student> studs=new ArrayList<>();
		List<String> courseList=new ArrayList<>();
				
		try(Scanner sc=new Scanner(System.in);) {
			System.out.println("Enroll student in course->");
			System.out.println("enter student details as: name age courseList, one by one");
			Student s=new Student();
			String name=sc.next();
			int age=sc.nextInt();
			while (courseList.add(sc.next())) {
				System.out.println("added course");
			}
			s.setStudentName(name);
			s.setStudentAge(age);
			s.setCourseList(courseList);
			studs.add(s);
		}
	}
}

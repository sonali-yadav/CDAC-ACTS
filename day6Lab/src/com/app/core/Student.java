//NOTE: how to auto insert getters and setters
// select the data members,then alt+shift+S

package com.app.core;

import java.util.Date;

public class Student implements Comparable<Student> {
	private String prn, name, email;
	private CourseType course;
	private int marks;
	private Date dob;

	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CourseType getCourse() {
		return course;
	}

	public void setCourse(CourseType course) {
		this.course = course;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	//DEFAULT CONSTRUCTOR
	public Student() {
		prn = name = email = "";
		dob = null;
		marks = 0;
	}

	//PARAMETERIZED CONSTRUCTOR
	public Student(String prn, String name, String email, CourseType course, int marks, Date dob) {
		this.prn = prn;
		this.name = name;
		this.email = email;
		this.course = course;
		this.marks = marks;
		this.dob = dob;
	}

	//OVERRIDDEN METHODS
	@Override
	public String toString() {
		return "PRN->" + prn + ",name->" + name + ",email->" + email + ",course->" + course + ",marks->" + marks
				+ ",dob->" + dob;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return prn.equals(((Student) obj).prn);
		}
		return false;
	}

	@Override
	public int compareTo(Student myStudent) {
		return prn.compareTo(myStudent.prn);
	}
}

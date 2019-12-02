package pojo;

import java.util.List;

public class Student {
	private String studentName;
	private static int counter;
	private int studentId, studentAge;
	private List<String> courseList;

	public Student() {
		super();
		studentId = ++counter;
	}

	public Student(String studentName, int studentAge, List<String> courseList) {
		super();
		studentId = ++counter;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.courseList = courseList;
	}

	public Student(String studentName, int studentId, int studentAge, List<String> courseList) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentAge = studentAge;
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", studentAge=" + studentAge
				+ ", courseList=" + courseList + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}
	
}

package com.app.pojos;

import java.util.List;
import javax.persistence.*;

//WILL REPRESENT THE COURSE TABLE IN THE DB

@Entity
@Table(name = "course_master")
public class Course {

	private int id;
	private String name;
	private List<Student> students;

	public Course() {
		super();
		System.out.println("Course()");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique = true, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//MAPPED BY COURSE FIELD OF STUDENT, ONE TO MANY RELATIONSHIP
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	//HELPER METHOD TO ADD A NEW STUDENT
	
	public void addStudent(Student s) {
		students.add(s);
		s.setCourse(this);
	}
}

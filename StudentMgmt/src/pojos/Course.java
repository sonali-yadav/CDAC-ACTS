package pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Date startDate, endDate;
	private double fees;
	private List<Student> students;

	public Course() {
		System.out.println("insdide Course() ctor");
		students=new ArrayList<>();
		
	}

}

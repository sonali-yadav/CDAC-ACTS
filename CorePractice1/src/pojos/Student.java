package pojos;

public class Student {

	private static int counter;
	private int id;
	private String name, email, address, phone_no, course_name;
	private double marks;

	// default constructor
	public Student() {
		super();
		id = ++counter;
	}

	// param constructors
	public Student(String name, String email, String address, String phone_no, String course_name, double marks) {
		super();
		this.id = ++counter;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone_no = phone_no;
		this.course_name = course_name;
		this.marks = marks;
	}
	
	public Student(int id, String name, String email, String address, String phone_no, String course_name,
			double marks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone_no = phone_no;
		this.course_name = course_name;
		this.marks = marks;
	}

	// getters and setters

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone_no="
				+ phone_no + ", course_name=" + course_name + ", marks=" + marks + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return this.email.equals(((Student) obj).getEmail());
		} else
			return false;
	}
}

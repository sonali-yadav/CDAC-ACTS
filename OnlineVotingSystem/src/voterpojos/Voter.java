package voterpojos;

public class Voter {
	private int id;
	private String email,password,status;
	private int role;
	private String name;

	
	public Voter(int id, String email, String password, String status) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "id->"+id+" name->"+name+" email->"+email
				+" status->"+(status.equals("N")? "Not Voted Yet":"Voted"
				+" Admin? ->"+(role==1? "Yes":"No"));
	}
}

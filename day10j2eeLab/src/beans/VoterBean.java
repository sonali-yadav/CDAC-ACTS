package beans;

import daos.VotingDaoImpl;
import pojos.*;

/*What will the bean actually do? or have?
1) will have all attributes which user can have during the session
2) talk to the DAO through dao object
3) so, in ctor, create the dao object
4) then it will have business logic too, like authentication, using the dao*/

public class VoterBean {
	private String email, password, name;
	private String loginMsg;
	private VotingDaoImpl vdao;
	private Voter v;

	// CONSTRUCTOR
	public VoterBean() {
		System.out.println("inside VoterBean()");
		vdao = new VotingDaoImpl();
	}

	// GETTERS AND SETTERS

	public String getEmail() {
		return email;
	}

	public String getLoginMsg() {
		return loginMsg;
	}

	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Voter getV() {
		return v;
	}

	public void setV(Voter v) {
		this.v = v;
	}

	// BUSINESS LOGIC METHODS

	// login validation
	public String authenticateVoter() throws Exception {
		System.out.println("inside authenticate voter with email=" + email + " and pwd=" + password);
		try {
			v = vdao.authenticateVoter(email, password);
			if (v.getStatus().equals("N")) {
				return "candidates";
			} else {
				loginMsg = "<div class='alert alert-info' role='alert'"
						+ " style='width: 80%;margin: 1em auto;'>You have already cast your vote. Thanks.</div>";
				return "status";
			}
		} catch (RuntimeException e) {
			loginMsg = "<div class='alert alert-danger' role='alert'"
					+ " style='width: 80%;margin: 1em auto;'>Invalid Login. Please Retry.</div>";
			System.out.println("error in authentication bean:" + getClass().getName() + " " + e);
			return "index";

		}
	}

	// registering a new voter
//	public String registerVoter() throws Exception {
//		boolean b = vdao.registerVoter(email, password, name);
//		if (b) {
//			loginMsg = "<div class='alert alert-success' role='alert'"
//					+ " style='width: 80%;margin: 1em auto;'>Registraton Successful. Please login.</div>";
//			return "index";
//		}
//		loginMsg = "<div class='alert alert-danger' role='alert'"
//				+ " style='width: 80%;margin: 1em auto;'>Couldn't Register. Please Retry.</div>";
//		return "register";
//	}

	// admin check 
	public int getAdminStatus() throws Exception {
		System.out.println("inside beans adminStatus");
		if (v.getRole() == 1)
			return 1;
		else
			return 0;
	}

}
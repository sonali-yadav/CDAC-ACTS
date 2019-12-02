package voterbeans;

import voterdaos.VotingDaoImpl;
import voterpojos.Voter;

/*What will the bean actually do? or have?
1) will have all attributes which user can have during the session
2) talk to the DAO through dao object
3) so, in ctor, create the dao object
4) then it will have business logic too, like authentication, using the dao*/

public class VoterBean {
	private String email, password, name;
	private String loginMsg;
	private VotingDaoImpl vdao;
	private int candid;

	// CONSTRUCTOR
	public VoterBean() throws Exception {
		System.out.println("inside VoterBean()");
		vdao = new VotingDaoImpl();
	}

	// GETTERS AND SETTERS

	public String getEmail() {
		return email;
	}

	public int getCandid() {
		return candid;
	}

	public void setCandid(int candid) {
		this.candid = candid;
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

	// BUSINESS LOGIC METHODS

	// login validation
	public String authenticateVoter() throws Exception {
		Voter v = vdao.authenticateVoter(email, password);
		if (v == null) {
			loginMsg = "<div class='alert alert-danger' role='alert'"
					+ " style='width: 80%;margin: 1em auto;'>Invalid Login. Please Retry.</div>";
			return "index";
		} else {
			System.out.println("inside authenticateVoter() else");
			int voteStatus = vdao.getVoterStatus(email);
			System.out.println("inside authenticateVoter() else: voteStatus" + voteStatus);
			if (voteStatus == 0) {
				return "candidates";
			} else
				loginMsg = "<div class='alert alert-info' role='alert'"
						+ " style='width: 80%;margin: 1em auto;'>You have already cast your vote. Thanks.</div>";
			return "status";
		}
	}

	// casting the vote
	public String castVote() throws Exception {
		int voterId = vdao.getIdByEmail(email);
		System.out.println("voterId=" + voterId);
		System.out.println("candid=" + candid);
		if (vdao.getVoterStatus(email) == 0) {
			String st = vdao.incVotesUpdateStatus(candid, voterId);
			if (st.equals("true")) {
				loginMsg = "<div class='alert alert-success' role='alert'"
						+ " style='width: 98%;margin: 1em auto;'>Vote Cast Successfully.</div>";
			} else {
				loginMsg = "<div class='alert alert-danger' role='alert'"
						+ " style='width: 98%;margin: 1em auto;'>Vote could not be cast. Please Retry.</div>";
			}
		}
		return loginMsg;
	}

	// registering a new voter
	public String registerVoter() throws Exception {
		boolean b = vdao.registerVoter(email, password, name);
		if (b) {
			loginMsg = "<div class='alert alert-success' role='alert'"
					+ " style='width: 80%;margin: 1em auto;'>Registraton Successful. Please login.</div>";
			return "index";
		}
		loginMsg = "<div class='alert alert-danger' role='alert'"
				+ " style='width: 80%;margin: 1em auto;'>Couldn't Register. Please Retry.</div>";
		return "register";
	}

	// admin check
	public int getAdminStatus() throws Exception {
		System.out.println("inside beans adminStatus");
		return vdao.getAdminStatus(email);
	}
}
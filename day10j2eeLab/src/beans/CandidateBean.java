package beans;

import java.util.LinkedHashMap;
import java.util.List;

import daos.CandidateDaoImpl;
import daos.VotingDaoImpl;
import pojos.*;

public class CandidateBean {

	private List<Candidate> candidateList;
	private CandidateDaoImpl vdao;
	private VotingDaoImpl votingDao;
	private Voter v;
	private int candid;
	private String loginMsg;

	public CandidateBean() {
		System.out.println("inside candidate bean");
		vdao = new CandidateDaoImpl();
		votingDao=new VotingDaoImpl();
	}

	public String getLoginMsg() {
		return loginMsg;
	}

	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
	}

	public int getCandid() {
		return candid;
	}

	public void setCandid(int candid) {
		this.candid = candid;
	}

	public Voter getV() {
		return v;
	}

	public void setV(Voter v) {
		this.v = v;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	// casting the vote
	public String castYourVote() throws Exception {
		System.out.println("inside cast vote");
		try {
			String s = vdao.incVotesUpdateStatus(candid);
			String ss=votingDao.updateVotingStatus(v);
			if (s.equals("Y")&& ss.equals("Y")) {
				loginMsg = "<div class='alert alert-success' role='alert'"
						+ " style='width: 98%;margin: 1em auto;'>Vote Cast Successfully.</div>";
			} else {
				loginMsg = "<div class='alert alert-danger' role='alert'"
						+ " style='width: 98%;margin: 1em auto;'>Vote could not be cast. Please Retry.</div>";
			}
		} catch (Exception e) {
			System.out.println("error in authentication bean:" + getClass().getName() + " " + e);
		}
		return loginMsg;
	}

	// generating the candidate list
	public List<Candidate> generateCandidateList() throws Exception {
		return vdao.getCandidateList();
	}

	// admin role: top two candidates
	public List<Candidate> getTopTwoCandidateList() throws Exception {
		return vdao.getTopTwoCandidates();
	}

//	// admin role: party wise votes analysis report
//	public LinkedHashMap<String, Integer> getPartyWiseAnalysis() throws Exception {
//		return vdao.getVoteAnalysisByParty();
//	}

}

package voterbeans;

import java.util.LinkedHashMap;
import java.util.List;
import voterdaos.VotingDaoImpl;

import voterpojos.Candidate;

public class CandidateBean {

	private List<Candidate> candidateList;
	private VotingDaoImpl vdao;

	public CandidateBean() throws Exception {
		System.out.println("inside candidate bean");
		vdao = new VotingDaoImpl();
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	// generating the candidate list
	public List<Candidate> generateCandidateList() throws Exception {
		return vdao.getCandidateList();
	}

	// admin role: top two candidates
	public List<Candidate> getTopTwoCandidateList() throws Exception {
		return vdao.getTopTwoCandidates();
	}

	// admin role: party wise votes analysis report
	public LinkedHashMap<String,Integer> getPartyWiseAnalysis() throws Exception {
		return vdao.getVoteAnalysisByParty();
	}

}

package daos;

import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public interface CandidateDao {

	public List<Candidate> getCandidateList() throws Exception;
	public String incVotesUpdateStatus(int candidateId) throws Exception;
	public List<Candidate> getTopTwoCandidates() throws Exception;
//	public LinkedHashMap<String,Integer> getVoteAnalysisByParty() throws Exception;

}

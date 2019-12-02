package voterdaos;

import java.util.HashMap;
import java.util.List;
import voterpojos.*;

public interface VotingDao {

	public Voter authenticateVoter(String email,String password) throws Exception;
	public List<Candidate> getCandidateList() throws Exception;
	public String incVotesUpdateStatus(int candidateId,int voterId) throws Exception;
	public boolean registerVoter(String email,String password, String name) throws Exception;
	public List<Candidate> getTopTwoCandidates() throws Exception;
	public HashMap<String,Integer> getVoteAnalysisByParty() throws Exception;
	public int getIdByEmail(String email) throws Exception;
	public int getVoterStatus(String email) throws Exception;
	public int getAdminStatus(String email) throws Exception;
}

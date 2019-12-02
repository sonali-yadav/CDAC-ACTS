package com.app.dao;

import com.app.pojos.Voter;
import java.util.List;
import com.app.pojos.*;

public interface VotingDao {

	public Voter authenticateVoter(String email,String password) throws Exception;
	public List<Candidate> getCandidateList() throws Exception;
	public String incVotesUpdateStatus(int candidateId,int voterId) throws Exception;
}

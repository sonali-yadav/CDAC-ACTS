package com.app.dao;

import java.util.List;

import com.app.pojos.Candidate;

public interface CandidateDao {
	List<Candidate> getCandidateList();

	String incVotes(int candidateId);
//	public List<Candidate> getTopTwoCandidates();
//	public List<Analysis> getVoteAnalysisByParty();
}

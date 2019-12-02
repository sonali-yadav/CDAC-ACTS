package com.app.dao;

import com.app.pojos.Voter;

public interface VoterDao {
	Voter authenticateVoter(String email, String password);

	String updateVotingStatus(Voter v);

}

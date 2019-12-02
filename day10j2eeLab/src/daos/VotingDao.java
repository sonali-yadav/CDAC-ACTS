package daos;

import pojos.*;

public interface VotingDao {

	Voter authenticateVoter(String email, String password) throws Exception;

	// detached pojo reference from HttpSession is being passed to this
	// then it becomes persistent, we update its state, and then it is updated in
	// the database on commit
	String updateVotingStatus(Voter v) throws Exception;

//	public boolean registerVoter(String email,String password, String name) throws Exception;
}

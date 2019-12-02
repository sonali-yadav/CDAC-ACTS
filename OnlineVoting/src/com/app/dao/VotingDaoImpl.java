package com.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.app.utils.DBUtils.*;
import com.app.pojos.Candidate;
import com.app.pojos.Voter;

public class VotingDaoImpl implements VotingDao {

	private Connection conn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public VotingDaoImpl() throws Exception {
		conn = fetchConnection();
		pst1 = conn.prepareStatement("select * from voters where email=? and password=?");
		pst2 = conn.prepareStatement("select * from candidates");
		pst3 = conn.prepareStatement("update voters set status='Y' where id=?");
		pst4 = conn.prepareStatement("update candidates set votes=(votes)+1 where id=?");
	}

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public Voter authenticateVoter(String email, String password) throws Exception {
		pst1.setString(1, email);
		pst1.setString(2,password);
		try(ResultSet rst=pst1.executeQuery();) {
			if (rst.next()) {
				return new Voter(rst.getInt(1), email, password, rst.getString(4));	
			}
		}
		return null;
	}

	@Override
	public List<Candidate> getCandidateList() throws Exception {
		List<Candidate> ls=new ArrayList<>();
		try(ResultSet rst2=pst2.executeQuery();) {
			while (rst2.next()) {
				ls.add(new Candidate(rst2.getInt(1), rst2.getString(2), rst2.getString(3), rst2.getInt(4)));				
			}
		}
		return ls;
	}

	@Override
	public String incVotesUpdateStatus(int candidateId, int voterId) throws Exception {
		pst3.setString(1, voterId+"");
		pst4.setString(1, candidateId+"");
		int q=pst3.executeUpdate();
		int qq=pst4.executeUpdate();
		if(q==1 && qq==1)
			return "true";
		else
			return "false";
	}

}

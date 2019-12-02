package voterdaos;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static voterutils.VoterDbUtils.*;
import voterpojos.*;

public class VotingDaoImpl implements VotingDao {

	private Connection conn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5, pst6, pst7,pst8,pst9,pst10;

	public VotingDaoImpl() throws Exception {
		conn = fetchConnection();
		pst1 = conn.prepareStatement("select * from voters where email=? and password=?");
		pst2 = conn.prepareStatement("select * from candidates");
		pst3 = conn.prepareStatement("update voters set status='Y' where id=?");
		pst4 = conn.prepareStatement("update candidates set votes=(votes)+1 where id=?");
		pst5 = conn.prepareStatement("insert into voters values (default,?,?,'N',0,?)");
		pst6 = conn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst7 = conn.prepareStatement("select political_party,sum(votes) from candidates group by "
				+ "political_party order by sum(votes) desc");
		pst8= conn.prepareStatement("select id from voters where email=?");
		pst9=conn.prepareStatement("select status from voters where email=?");
		pst10=conn.prepareStatement("select role from voters where email=?");
		
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
		if (pst5 != null)
			pst5.close();
		if (pst6 != null)
			pst6.close();
		if (pst7 != null)
			pst7.close();
		if (pst8 != null)
			pst8.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public Voter authenticateVoter(String email, String password) throws Exception {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery();) {
			if (rst.next()) {
				return new Voter(rst.getInt(1), email, password, rst.getString(4));
			}
		}
		return null;
	}

	@Override
	public List<Candidate> getCandidateList() throws Exception {
		List<Candidate> ls = new ArrayList<>();
		System.out.println("inside getCandidateList of dao layer, outside try");
		try (ResultSet rst2 = pst2.executeQuery();) {
			System.out.println("inside getCandidateList of dao layer");
			while (rst2.next()) {
				ls.add(new Candidate(rst2.getInt(1), rst2.getString(2), rst2.getString(3), rst2.getInt(4)));
			}
		}
		return ls;
	}

	@Override
	public String incVotesUpdateStatus(int candidateId, int voterId) throws Exception {
		pst3.setString(1, voterId + "");
		pst4.setString(1, candidateId + "");
		int q = pst3.executeUpdate();
		int qq = pst4.executeUpdate();
		if (q == 1 && qq == 1)
			return "true";
		else
			return "false";
	}

	@Override
	public boolean registerVoter(String email, String password, String name) throws Exception {
		pst5.setString(1, email);
		pst5.setString(2, password);
		pst5.setString(3, name);
		int q = pst5.executeUpdate();
		if (q == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<Candidate> getTopTwoCandidates() throws Exception {
		List<Candidate> al = new ArrayList<>();
		try (ResultSet rst = pst6.executeQuery();) {
			while (rst.next()) {
				al.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getLong(4)));
			}
		}
		return al;
	}

	@Override
	public LinkedHashMap<String, Integer> getVoteAnalysisByParty() throws Exception {
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
		try(ResultSet rst=pst7.executeQuery();){
			while(rst.next()) {
				hm.put(rst.getString(1), rst.getInt(2));
			}
		}
		return hm;
	}

	@Override
	public int getIdByEmail(String email) throws Exception {
		pst8.setString(1, email);
		int q=-1;
		try (ResultSet rst = pst8.executeQuery();) {
			rst.next();
			q=rst.getInt(1);
		}
		return q;
	}

	@Override
	public int getVoterStatus(String email) throws Exception {
		pst9.setString(1, email);
		try (ResultSet rst = pst9.executeQuery();) {
			rst.next();
			String g=rst.getString(1);
			if (g.equals("N")) {
				return 0;
			} else
				return 1;
		}
	}

	@Override
	public int getAdminStatus(String email) throws Exception {
		System.out.println("inside adminStatus");
		pst10.setString(1, email);
		try (ResultSet rst = pst10.executeQuery();) {
			rst.next();
			String g=rst.getString(1);
			if (g.equals("1")) {
				return 1;
			} else
				return 0;
		}
	}

}

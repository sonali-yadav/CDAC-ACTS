package daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.*;
import pojos.*;

public class VotingDaoImpl implements VotingDao {

	@Override
	public Voter authenticateVoter(String email, String password) throws Exception {
		String jpql="select v from Voter v where v.email=:em and v.password=:pw";
		Voter v=null;
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		try {
			v=hs.createQuery(jpql,Voter.class).setParameter("em", email).setParameter("pw", password).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return v;
	}

	@Override
	public String updateVotingStatus(Voter v) throws Exception {
		String msg="N";
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		try {
			hs.update(v);
			v.setStatus("Y");
			msg="Y";
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
/*
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

*/
}

package daos;

import static utils.HibernateUtils.getSf;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.*;

public class CandidateDaoImpl implements CandidateDao {

	@Override
	public List<Candidate> getCandidateList() throws Exception {
		String jpql = "select c from Candidate c";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		List<Candidate> candidates = null;
		try {
			candidates = hs.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return candidates;
	}

	@Override
	public String incVotesUpdateStatus(int candidateId) throws Exception {
		String jpql = "select c from Candidate c where c.id=:cid";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		String msg = "N";
		Candidate candidate = null;
		try {
			candidate = hs.createQuery(jpql, Candidate.class).setParameter("cid", candidateId).getSingleResult();
			candidate.setVotes(candidate.getVotes() + 1);
			msg = "Y";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<Candidate> getTopTwoCandidates() throws Exception {
		String jpql = "select c from Candidate c order by c.votes desc";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		List<Candidate> candidates = null;
		try {
			candidates = hs.createQuery(jpql, Candidate.class).setMaxResults(2).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return candidates;
	}

//	@Override
//	public LinkedHashMap<String, Integer> getVoteAnalysisByParty() throws Exception {
//		LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
//		String jpql = "select c.political_party,sum(c.votes) from Candidate c group by c.political_party order by sum(c.votes) desc";
//		Session hs = getSf().getCurrentSession();
//		Transaction tx = hs.beginTransaction();
//		try {
//			List<Object[]> candidates = hs.createQuery(jpql,Object[].class).getResultList();
//			for (Object[] ob : candidates) {
//				hm.put((String)ob[0], (Integer)ob[1]);
//			}
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			throw e;
//		}
//		return hm;
//	}
}

package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Candidate;

@Repository
@Transactional
public class CandidateDaoImpl implements CandidateDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Candidate> getCandidateList() {
		String jpql = "select c from Candidate c";
		return sf.getCurrentSession().createQuery(jpql, Candidate.class).getResultList();
	}

	@Override
	public String incVotes(int candidateId) {
		Candidate c = sf.getCurrentSession().get(Candidate.class, candidateId);
		if (c != null) {
			c.setVotes(c.getVotes() + 1);
			return "Y";
		}
		return "N";
	}

}

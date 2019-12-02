package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Voter;

@Repository
@Transactional
public class VoterDaoImpl implements VoterDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Voter authenticateVoter(String email, String password){
		String jpql="select v from Voter v where v.email=:em and v.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Voter.class)
				.setParameter("em", email).setParameter("pass", password).getSingleResult();
	}

	@Override
	public String updateVotingStatus(Voter v) {
		System.out.println("inside updateVotingStatus");
		v.setStatus("Y");
		sf.getCurrentSession().update(v);
		return "1";
	}

}

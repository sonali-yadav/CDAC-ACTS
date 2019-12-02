package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Course;

//COURSE DAO LAYER AUTOWIRED TO SESSIONFACTORY

@Repository
@Transactional
public class ICourseDaoImpl implements ICourseDao {

	public ICourseDaoImpl() {
		System.out.println("ICourseDaoImpl()");
	}

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Course> getCourseList() {
		String jpql = "select c from Course c";
		return sf.getCurrentSession().createQuery(jpql, Course.class).getResultList();
	}

	@Override
	public Course deleteCourse(int cid) {
		Session hs=sf.getCurrentSession();
		Course c=hs.get(Course.class, cid);
		if (c!=null) {
			hs.delete(c);
		}
		return c;
	}

}

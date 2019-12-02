package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Course;
import com.app.pojos.Student;

//STUDENT DAO LAYER, AUTOWIRED TO THE SESSIONFACTORY

@Repository
@Transactional
public class IStudentDaoImpl implements IStudentDao {

	public IStudentDaoImpl() {
		System.out.println("IStudentDaoImpl()");
	}

	@Autowired
	private SessionFactory sf;

	@Override
	public int addStudent(Student s, int cid) {
		System.out.println("inside addStudent() value of cid="+cid);
		Course c = sf.getCurrentSession().get(Course.class, cid);
		c.addStudent(s);
		return 1;
	}
}
package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements IDepartmentDao {

	@Autowired
	private SessionFactory sf;
	
	public DepartmentDaoImpl() {
	System.out.println("inside  DepartmentDaoImpl() ctor");
	}

	@Override
	public List<Department> getDepartmentList() {
		List<Department> al=null;
		String jpql="select d from Department d";
		return sf.getCurrentSession().createQuery(jpql, Department.class).getResultList();
	}
}

package com.app.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SessionFactory sf;

	public EmployeeDaoImpl() {
		System.out.println("inside EmployeeDaoImpl() ctor");
	}

	@Override
	public String hireEmployee(Employee e, int deptId) {
		if (e.getSalary() >=20000 && e.getSalary() <=30000 && e.getDob().getYear() < 1995) {
			Department d = sf.getCurrentSession().get(Department.class, deptId);
			if (d != null) {
				d.hireEmployee(e);
				return "Y";
			}
		}
		return "N";
	}
}

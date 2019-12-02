package dao;

import static utils.HibernateUtils.*;

import java.util.List;

import org.hibernate.*;

import pojos.Department;
import pojos.Employee;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String createNewDeptDepartment(Department d) {
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		String msg="Adding Department Failed!";
		try {
			hs.save(d);
			tx.commit();
			msg="Adding Department Succeeded!";
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String fireEmp(int deptId, int empId) {
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		String msg="Firing Failed!";
		try {
			Department d=hs.get(Department.class,deptId);
			Employee e=hs.get(Employee.class,empId);
			d.removeEmployee(e);
			tx.commit();
			msg="Firing Succeeded!";
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String hireEmp(int deptId, Employee e) {
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		String msg="Hiring Failed!";
		try {
			Department d=hs.get(Department.class,deptId);
			d.addEmployee(e);
			tx.commit();
			msg="Hiring Succeeded!";
		} catch (HibernateException ex) {
			if (tx!=null)
				tx.rollback();
			throw ex;
		}
		return msg;
	}

	@Override
	public List<Employee> listEmps(String deptName) {
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		List<Employee> ls=null;
		String jpql="select d from Department d where d.name=:dpn";
		try {
			Department d=hs.createQuery(jpql, Department.class).setParameter("dpn", deptName).getSingleResult();
			ls=d.getEmps();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx!=null)
				tx.rollback();
			throw ex;
		}
		return ls;
	}
}
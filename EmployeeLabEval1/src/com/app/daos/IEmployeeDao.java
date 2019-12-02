package com.app.daos;

import com.app.pojos.Employee;

public interface IEmployeeDao {

	String hireEmployee(Employee e, int deptId);
}

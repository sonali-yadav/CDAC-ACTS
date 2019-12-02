package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface DepartmentDao {
	String createNewDeptDepartment (Department d);
	String hireEmp(int deptId,Employee e);
	List<Employee> listEmps(String deptName);
	String fireEmp(int deptId,int empId);	
}

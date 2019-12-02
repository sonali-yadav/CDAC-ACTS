package utils;

import java.util.ArrayList;

import custexception.EmployeeHandlingException;
import pojo.Employee;

public class CollectionUtils {

	public static Employee getEmployeeById(int id, ArrayList<Employee> emps) throws EmployeeHandlingException {
		for (Employee employee : emps) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		throw new EmployeeHandlingException("Student not found!");
	}

	public static Employee deleteEmployeeById(int id, ArrayList<Employee> emps) throws EmployeeHandlingException {
		Employee e = new Employee();
		e.setId(id);
		int i = emps.indexOf(e);
		if (i == -1)
			throw new EmployeeHandlingException("Student not found!");
		else {
			e=emps.get(i);
			emps.remove(i);
			return e;
		}
	}
}

package HRMS.hrms.bussines.abstracts;

import java.util.List;

import HRMS.hrms.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> getAll();

}

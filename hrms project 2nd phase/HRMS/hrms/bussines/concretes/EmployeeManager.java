package HRMS.hrms.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.EmployeeService;
import HRMS.hrms.dataAccess.abstracts.EmployeeDao;
import HRMS.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	public List<Employee> getAll() {
		
		return this.employeeDao.findAll();
	}

}

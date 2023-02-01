package HRMS.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.bussines.abstracts.EmployeeService;
import HRMS.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/getall")
	public List<Employee>getAll(){
		return employeeService.getAll();
		
	}
	
}

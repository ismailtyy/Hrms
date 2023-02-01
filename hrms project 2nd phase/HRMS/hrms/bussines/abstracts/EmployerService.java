package HRMS.hrms.bussines.abstracts;

import java.util.List;

import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();

}

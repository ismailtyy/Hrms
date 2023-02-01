package HRMS.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.core.verifications.abstracts.ConsentOfHrmsEmployeeService;
@Service
public class ConsentOfHrmsEmployeeManager implements ConsentOfHrmsEmployeeService{

	@Override
	public Result verifyAccount() {
	
		return new SuccessResult("Account verified by hrms employee.");
	}

}

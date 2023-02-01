package HRMS.hrms.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.EmployerService;
import HRMS.hrms.bussines.abstracts.VerificationRuleServie;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.ErrorResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessDataResult;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.core.verifications.abstracts.ConsentOfHrmsEmployeeService;
import HRMS.hrms.core.verifications.abstracts.EmailVerificationService;
import HRMS.hrms.core.verifications.concretes.EmailVerificationManager;
import HRMS.hrms.dataAccess.abstracts.EmployerDao;
import HRMS.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private VerificationRuleServie verificationRuleService;
	private ConsentOfHrmsEmployeeService employeeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			VerificationRuleServie verificationRuleService, ConsentOfHrmsEmployeeService employeeService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.verificationRuleService = verificationRuleService;
		this.employeeService = employeeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Employer listed.");
	}

	@Override
	public Result add(Employer employer) {
		Result verificationRule = verificationRuleService.checkEmployer(employer);
		if (!verificationRule.isSuccess()) {
			return new ErrorResult(verificationRule.getMessage());
		}
		boolean emailVerificationService = checkEmail(employer);
		if (emailVerificationService) {
			return new ErrorResult("E-mail already exists.");
		} else if (!EmailVerificationManager.checkEmailDomain(employer.getWebAddress(),employer.getEmail())) {
			return new ErrorResult("Your web address domain is not match your email.");
		} else if (!employer.getPassword().equals(employer.getRepeatPassword())) {
			return new ErrorResult("Passwords do not match.");
		}

		System.out.println(this.emailVerificationService.verifyEmail(employer.getEmail()).getMessage() + "/n"
				+ this.employeeService.verifyAccount().getMessage());
		employerDao.save(employer);

		return new SuccessResult("Added to the employer system.");
	}

	private boolean checkEmail(Employer employer) {
		Employer findByEmailResult = employerDao.findByEmail(employer.getEmail());
		if (findByEmailResult == null) {
			return false;
		}
		return true;
	}

}

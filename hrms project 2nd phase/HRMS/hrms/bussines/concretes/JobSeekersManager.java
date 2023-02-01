package HRMS.hrms.bussines.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.JobSeekersService;
import HRMS.hrms.bussines.abstracts.VerificationRuleServie;
import HRMS.hrms.core.adapters.abstracts.MernisService;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.ErrorResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessDataResult;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.core.verifications.abstracts.EmailVerificationService;
import HRMS.hrms.dataAccess.abstracts.JobSeekersDao;
import HRMS.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService {
	private JobSeekersDao jobSeekersDao;
	private MernisService mernisService;
	private VerificationRuleServie verificationRuleServie;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, MernisService mernisService,
			VerificationRuleServie verificationRuleServie, EmailVerificationService emailVerificationService) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.mernisService = mernisService;
		this.verificationRuleServie = verificationRuleServie;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public Result add(JobSeekers jobSeekers) throws NumberFormatException, RemoteException {
		Result verificationRule = verificationRuleServie.checkJobSeekers(jobSeekers);
		if (!verificationRule.isSuccess()) {
			return new ErrorResult(verificationRule.getMessage());
		}

		boolean mernisVerificationRule = checkPerson(jobSeekers);
		if (!mernisVerificationRule) {
			return new ErrorResult("Contact not found, check credentials.");
		}
		boolean emailandIdentityNumberExists = checkEmailandIdentityNumber(jobSeekers);
		if (!emailandIdentityNumberExists) {
			return new ErrorResult("E-mail or identity number already exists.");
		}
		System.out.println(emailVerificationService.verifyEmail(jobSeekers.getEmail()).getMessage());
		jobSeekersDao.save(jobSeekers);
		return new SuccessResult("job seeker successfully added to the system.");
	}

	private boolean checkEmailandIdentityNumber(JobSeekers jobSeekers) {
		JobSeekers findByEmailOrIdentityNumberResult = jobSeekersDao.findByEmailOrIdentityNumber(jobSeekers.getEmail(),
				jobSeekers.getIdentityNumber());
		if (findByEmailOrIdentityNumberResult == null) {
			return false;
		}
		return true;
	}

	public boolean checkPerson(JobSeekers jobSeekers) throws NumberFormatException, RemoteException {
		boolean mernisVerificationRule = mernisService.checkPerson(jobSeekers);
		if (!mernisVerificationRule) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {

		return new SuccessDataResult<List<JobSeekers>>(jobSeekersDao.findAll(), "Job Seekers listed.");
	}

}

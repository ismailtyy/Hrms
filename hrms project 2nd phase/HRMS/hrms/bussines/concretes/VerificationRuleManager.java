package HRMS.hrms.bussines.concretes;

import java.time.Year;

import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.VerificationRuleServie;
import HRMS.hrms.core.results.ErrorResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.core.verifications.concretes.EmailVerificationManager;
import HRMS.hrms.entities.concretes.Employer;
import HRMS.hrms.entities.concretes.JobSeekers;

@Service
public class VerificationRuleManager implements VerificationRuleServie {

	@Override
	public Result checkJobSeekers(JobSeekers jobSeekers) {
		Year currentYear = Year.now();
		if (jobSeekers.getFirstName().isEmpty() || jobSeekers.getLastName().isEmpty()
				|| jobSeekers.getIdentityNumber().isEmpty() || jobSeekers.getEmail().isEmpty()
				|| jobSeekers.getPassword().isEmpty()) {
			return new ErrorResult("This field cannot be left blank.");

		}
		if (jobSeekers.getBirthYear() <= 0 || jobSeekers.getBirthYear() > currentYear.getValue()) {
			return new ErrorResult("Wrong year of birth.");
		}
		return new SuccessResult("Job seeker identity verified.");
	}

	@Override
	public Result checkEmployer(Employer employer) {
		if (employer.getCompanyName().isEmpty() || employer.getWebAddress().isEmpty() || employer.getEmail().isEmpty()
				|| employer.getPassword().isEmpty() || employer.getRepeatPassword().isEmpty()) {
			return new ErrorResult("This field cannot be left blank.");

		}
		return new SuccessResult("Employer information verified.");
	}

}

package HRMS.hrms.bussines.abstracts;

import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.Employer;
import HRMS.hrms.entities.concretes.JobSeekers;

public interface VerificationRuleServie {
	Result checkJobSeekers(JobSeekers jobSeekers);

	Result checkEmployer(Employer employer);

}

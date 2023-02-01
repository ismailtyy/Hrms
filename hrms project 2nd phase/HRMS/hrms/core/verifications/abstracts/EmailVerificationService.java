package HRMS.hrms.core.verifications.abstracts;

import HRMS.hrms.core.results.Result;

public interface EmailVerificationService {
	Result verifyEmail(String email);

}

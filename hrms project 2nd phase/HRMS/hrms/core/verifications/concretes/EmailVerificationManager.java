package HRMS.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.core.verifications.abstracts.EmailVerificationService;
@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		
		return new SuccessResult("Verification e-mail sent. Check your e-mail box." + " "+ email);
	}

	
	public static boolean checkEmailDomain(String webAddress, String email) {
		return webAddress.contains(email.split("@")[1]);
	}

}

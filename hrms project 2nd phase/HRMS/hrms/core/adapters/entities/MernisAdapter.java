package HRMS.hrms.core.adapters.entities;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import HRMS.hrms.core.adapters.abstracts.MernisService;
import HRMS.hrms.entities.concretes.JobSeekers;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisAdapter implements MernisService {

	@Override
	public boolean checkPerson(JobSeekers jobSeekers) throws NumberFormatException, RemoteException {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		return kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getIdentityNumber()),
				jobSeekers.getFirstName().toUpperCase(), jobSeekers.getLastName().toUpperCase(),
				jobSeekers.getBirthYear());
	}

}

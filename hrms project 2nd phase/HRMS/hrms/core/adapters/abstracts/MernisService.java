package HRMS.hrms.core.adapters.abstracts;

import java.rmi.RemoteException;

import HRMS.hrms.entities.concretes.JobSeekers;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public interface MernisService {
	public boolean checkPerson(JobSeekers jobSeekers) throws NumberFormatException, RemoteException;
}

package HRMS.hrms.bussines.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {
	Result add(JobSeekers jobSeekers) throws NumberFormatException, RemoteException;
	
	DataResult<List<JobSeekers>> getAll();

}

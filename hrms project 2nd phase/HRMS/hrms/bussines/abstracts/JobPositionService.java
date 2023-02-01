package HRMS.hrms.bussines.abstracts;

import java.util.List;

import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();

	Result add(JobPosition jobPosition);

}

package HRMS.hrms.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.JobPositionService;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.ErrorResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessDataResult;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.JobPositionDao;
import HRMS.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "Query returned successfully.");
	}

	@Override
	public Result add(JobPosition jobPosition) {

		if (this.jobPositionDao.findByTitle(jobPosition.getTitle()) != null) {
			return new ErrorResult("Job position exists in the database.");
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position has added successfully.");
	}
}

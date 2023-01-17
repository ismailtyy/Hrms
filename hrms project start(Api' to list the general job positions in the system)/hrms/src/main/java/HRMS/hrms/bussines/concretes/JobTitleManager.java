package HRMS.hrms.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.JobTitleService;
import HRMS.hrms.dataAccess.abstracts.JobTitleDao;
import HRMS.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	private JobTitleDao jobTitleDao;
	
    @Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}


	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}

}

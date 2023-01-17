package HRMS.hrms.bussines.abstracts;

import java.util.List;

import HRMS.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}

package HRMS.hrms.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.bussines.abstracts.JobSeekersService;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/job_seekers")
public class JobSeekersController {
	private JobSeekersService jobSeekersService;

	@Autowired
	public JobSeekersController(JobSeekersService jobSeekersService) {
		super();
		this.jobSeekersService = jobSeekersService;
	}
	@GetMapping("/getAll")
	public DataResult<List<JobSeekers>> getAll(){
		return jobSeekersService.getAll();
	} 

	@PostMapping("/add")
	public Result add(@RequestBody JobSeekers jobSeekers) throws NumberFormatException, RemoteException {
		return jobSeekersService.add(jobSeekers);
	}

}

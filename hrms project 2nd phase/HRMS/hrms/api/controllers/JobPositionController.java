package HRMS.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.bussines.abstracts.JobPositionService;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_titles")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {

		return this.jobPositionService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {

		return this.jobPositionService.add(jobPosition);
	}
}
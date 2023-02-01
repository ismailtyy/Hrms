package HRMS.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.bussines.abstracts.UserService;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/getall")
	public DataResult<List<User>> getall(){
		return userService.getAll();
	}	
	
	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return userService.add(user);
	}

}

package HRMS.hrms.bussines.abstracts;

import java.util.List;

import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>>getAll();
	
	Result add(User user);
	

}

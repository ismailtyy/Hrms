package HRMS.hrms.bussines.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.bussines.abstracts.UserService;
import HRMS.hrms.core.results.DataResult;
import HRMS.hrms.core.results.Result;
import HRMS.hrms.core.results.SuccessDataResult;
import HRMS.hrms.core.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.UserDao;
import HRMS.hrms.entities.concretes.User;

@Service
@Transactional
public class UserManager implements UserService {
	private UserDao userDao;



	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users data listed");

	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Users added");
	}

}

package HRMS.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HRMS.hrms.entities.concretes.JobSeekers;
@Repository
public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer> {
	JobSeekers findByEmailOrIdentityNumber(String email , String identityNumber);

}

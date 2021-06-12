package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeDao extends JpaRepository<JobType,Integer> {
}

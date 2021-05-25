package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    List<JobPosition> findByName(String jobPositionName);
}

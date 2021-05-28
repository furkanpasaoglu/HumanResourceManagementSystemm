package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> findByActiveTrue();
    List<JobAdvertisement> findByActiveTrueOrderByCreateDateAsc();
    List<JobAdvertisement> findByActiveTrueOrderByCreateDateDesc();
    List<JobAdvertisement> findByActiveTrueAndEmployerId(int employerId);
}

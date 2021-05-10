package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployerVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerVerificationDao extends JpaRepository<EmployerVerification,Integer> {
}

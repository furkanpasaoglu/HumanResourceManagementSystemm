package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.TypeOfWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfWorkDao extends JpaRepository<TypeOfWork,Integer> {
}

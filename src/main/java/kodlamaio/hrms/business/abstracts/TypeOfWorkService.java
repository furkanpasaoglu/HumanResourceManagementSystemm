package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.TypeOfWork;

import java.util.List;

public interface TypeOfWorkService {
    Result add(TypeOfWork typeOfWork);
    DataResult<List<TypeOfWork>> getAll();
    DataResult<TypeOfWork> getById(int id);
}

package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobType;

import java.util.List;

public interface JobTypeService {
    Result add(JobType jobType);
    DataResult<List<JobType>> getAll();
    DataResult<JobType> getById(int id);
}

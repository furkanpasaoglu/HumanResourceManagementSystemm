package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    Result add(WorkExperience workExperience);
    DataResult<List<WorkExperience>> findAllByOrderByEndDateDesc();
}

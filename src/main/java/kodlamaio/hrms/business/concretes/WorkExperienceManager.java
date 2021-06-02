package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {
    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        this.workExperienceDao.save(workExperience);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<WorkExperience>> findAllByOrderByEndDateDesc() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAllByOrderByEndDateDesc(),Messages.Listed);
    }
}

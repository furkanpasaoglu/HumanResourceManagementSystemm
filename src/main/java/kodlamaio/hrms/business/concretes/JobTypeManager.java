package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTypeDao;
import kodlamaio.hrms.entities.concretes.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeManager implements JobTypeService {
    private JobTypeDao jobTypeDao;

    @Autowired
    public JobTypeManager(JobTypeDao jobTypeDao) {
        this.jobTypeDao = jobTypeDao;
    }

    @Override
    public Result add(JobType jobType) {
        this.jobTypeDao.save(jobType);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<JobType>> getAll() {
        return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<JobType> getById(int id) {
        return new SuccessDataResult<JobType>(this.jobTypeDao.getOne(id),Messages.Listed);
    }
}

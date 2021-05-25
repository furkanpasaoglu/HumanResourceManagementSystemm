package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), Messages.Listed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = BusinessRules.run(checkForUserExist(jobPosition.getName()));

        if (result != null) {
            System.out.println(Messages.JobPositionCannotRepeat);
            return new ErrorResult(Messages.JobPositionCannotRepeat);
        }

        this.jobPositionDao.save(jobPosition);
        System.out.println("İş Pozisyonu Eklendi: " + jobPosition.getName());
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<JobPosition>> findByJobPositionName(String jobPositionName) {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findByName(jobPositionName));
    }

    private Result checkForUserExist(String jobPositionName){
        var result = this.jobPositionDao.findByName(jobPositionName);

        if (result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }
}

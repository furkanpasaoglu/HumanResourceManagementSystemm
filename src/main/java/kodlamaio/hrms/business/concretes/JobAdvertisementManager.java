package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        var jobAdvertisement1 = this.jobAdvertisementDao.getOne(jobAdvertisement.getJobAdvertisementId());
        jobAdvertisement1.setActive(false);
        this.jobAdvertisementDao.save(jobAdvertisement1);
        return new SuccessResult(Messages.Updated);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrue(), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndCreateDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreateDateAsc(), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreateDateDesc(), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueAndEmployerId(employerId), Messages.Listed);
    }
}

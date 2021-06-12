package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> findByActiveTrue();
    DataResult<List<JobAdvertisement>> findByActiveTrueAndCreateDateAsc();
    DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc();
    DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(int employerId);
}

package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    Result add(Candidate candidate);
    DataResult<List<Candidate>> getAll();
    DataResult<List<Candidate>> findByEmployerEmail(String email);
}

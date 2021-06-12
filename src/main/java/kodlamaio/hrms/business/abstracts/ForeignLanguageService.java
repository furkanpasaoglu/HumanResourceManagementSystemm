package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    Result add(ForeignLanguage foreignLanguage);
    DataResult<List<ForeignLanguage>> getAll();
}

package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface VerificationService {
    Result add(User user);
    DataResult<Boolean> checkForEmail(String... emails);
    Result sendVerificationMail();
    Result verifiedUser();
    Result noVerifiedUser();
}

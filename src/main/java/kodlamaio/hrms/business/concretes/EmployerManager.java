package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.business.validationRules.UserValidator;
import kodlamaio.hrms.core.utilities.business.ValidationTool;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserService userService;
    private VerificationService verificationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService, VerificationService verificationService) {
        this.employerDao = employerDao;
        this.userService = userService;
        this.verificationService = verificationService;
    }

    @Override
    public Result add(Employer employer) {
        var result = ValidationTool.run(EmployerValidator.Validator(employer), UserValidator.Validator(employer));

        if(result){
            var saveEmployer = this.employerDao.save(employer);
            this.userService.register(saveEmployer);
            this.verificationService.add(saveEmployer);
            return new SuccessResult("Başarıyla Şirket Profili Oluşturuldu.");
        }
        return new ErrorResult();
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
    }
}

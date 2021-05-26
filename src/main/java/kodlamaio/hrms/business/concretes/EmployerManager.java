package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.business.validationRules.UserValidator;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
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
    private EmployerVerificationService employerVerificationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService, VerificationService verificationService,EmployerVerificationService employerVerificationService) {
        this.employerDao = employerDao;
        this.userService = userService;
        this.verificationService = verificationService;
        this.employerVerificationService = employerVerificationService;
    }

    @Override
    public Result add(Employer employer) {
        var validator = ValidationTool.run(EmployerValidator.Validator(employer),UserValidator.Validator(employer));
        var result = BusinessRules.run(checkForEmail(employer.getEmail()));
        var verification = this.verificationService.checkForEmail(employer.getEmail()).isSuccess();

        if(validator){
            if(result !=null){
                System.out.println(Messages.CannotRepeat);
                return new ErrorResult(Messages.CannotRepeat);
            }

            if(!verification){
                var saveEmployer = this.employerDao.save(employer);
                this.userService.register(saveEmployer);
                this.verificationService.add(saveEmployer);
                this.employerVerificationService.add(employer);

                System.out.println("Şirket: "+employer.getCompany_name() + " " + Messages.Successful);
                return new SuccessResult(Messages.Successful);
            }
            System.out.println(Messages.RegistrationError);
            return new ErrorResult(Messages.RegistrationError);
        }
        System.out.println(Messages.Required);
        return new ErrorResult(Messages.Required);
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<List<Employer>> findByEmployerEmail(String email) {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findByEmail(email));
    }

    private Result checkForEmail(String email){
        var result = this.employerDao.findByEmail(email);

        if(result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }
}

package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.business.validationRules.UserValidator;
import kodlamaio.hrms.core.adapters.HrmsVerificationService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.business.ValidationTool;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserService userService;
    private VerificationService verificationService;
    private HrmsVerificationService hrmsVerificationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService, VerificationService verificationService,HrmsVerificationService hrmsVerificationService) {
        this.candidateDao = candidateDao;
        this.userService = userService;
        this.verificationService = verificationService;
        this.hrmsVerificationService = hrmsVerificationService;
    }

    @Override
    public Result add(Candidate candidate) {
        var validator = ValidationTool.run(CandidateValidator.Validator(candidate),UserValidator.Validator(candidate));
        var result = BusinessRules.run(checkForEmail(candidate.getEmail()));
        var verification = this.verificationService.checkForEmail(candidate.getEmail()).isSuccess();

        if(validator){
            if(result !=null){
                System.out.println(Messages.CandidateCannotRepeat);
                return new ErrorResult(Messages.CandidateCannotRepeat);
            }

            if(verification){
                if(this.hrmsVerificationService.CheckForIdentityNumber(candidate.getIdentity_number())){
                    var saveCandidate = this.candidateDao.save(candidate);
                    this.userService.register(saveCandidate);
                    this.verificationService.add(saveCandidate);
                    System.out.println("Üye: "+candidate.getFirst_name() + " " +candidate.getLast_name() + " " + Messages.Successful);
                    return new SuccessResult(Messages.Successful);
                }
                System.out.println(Messages.IdentityNumberFailed);
                return new ErrorResult(Messages.IdentityNumberFailed);
            }
            System.out.println(Messages.RegistrationError);
            return new ErrorResult(Messages.RegistrationError);
        }
        System.out.println(Messages.Required);
        return new ErrorResult(Messages.Required);
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<List<Candidate>> findByEmployerEmail(String email) {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmail(email));
    }

    private Result checkForEmail(String email){
        var result = this.candidateDao.findByEmail(email);

        if(result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }
}

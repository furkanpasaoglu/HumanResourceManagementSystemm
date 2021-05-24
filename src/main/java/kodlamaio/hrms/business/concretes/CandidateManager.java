package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.business.validationRules.UserValidator;
import kodlamaio.hrms.core.adapters.HrmsVerificationService;
import kodlamaio.hrms.core.utilities.business.ValidationTool;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;
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
        var result = ValidationTool.run(CandidateValidator.Validator(candidate), UserValidator.Validator(candidate));
        var verification = this.verificationService.checkForEmail(candidate.getEmail()).isSuccess();

        if(result && verification){
            if(this.hrmsVerificationService.CheckForIdentityNumber(candidate.getIdentity_number())){
                var saveCandidate = this.candidateDao.save(candidate);
                this.userService.register(saveCandidate);
                this.verificationService.add(saveCandidate);
                return new SuccessResult("Başarıyla Üye Profili Oluşturuldu.");
            }
            return new ErrorResult("Lütfen Vatandaşlık Numaranız 11 Haneli Olmak Zorunda");
        }
        return new ErrorResult();
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Başarıyla Listelendi");
    }
}

package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerVerificationDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployerVerificationManager implements EmployerVerificationService {
    private EmployerVerificationDao employerVerificationDao;
    private EmployerVerification verification;

    @Autowired
    public EmployerVerificationManager(EmployerVerificationDao employerVerificationDao) {
        this.employerVerificationDao = employerVerificationDao;
    }

    @Override
    public Result add(Employer employer) {
        this.verification = new EmployerVerification();
        this.verification.setEmployerId(employer.getId());
        this.verification.setConfirm(true);
        this.verification.setCreateDate(new Date());

        this.employerVerificationDao.save(this.verification);
        System.out.println("İş Verene Doğrulama İsteği Gönderildi.");
        return new SuccessResult(Messages.Added);
    }
}

package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VerificationManager implements VerificationService {
    private VerificationDao verificationDao;
    private Verification verification;

    @Autowired
    public VerificationManager(VerificationDao verificationDao) {
        this.verificationDao = verificationDao;
    }

    @Override
    public Result add(User user) {
        verification = new Verification();
        verification.setUserId(user.getId());
        verification.setConfirm(true);
        verification.setCreateDate(new Date());

        this.sendVerificationMail();
        this.verifiedUser();


        this.verificationDao.save(verification);
        System.out.println("Doğrulama İşlemi Yapıldı");
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<Boolean> checkForEmail(String... emails) {
        for (String email:emails){
            if(email.contains("@gmail") || email.contains("@hotmail") || email.contains("@outlook"))
                return new SuccessDataResult<Boolean>();
        }
        return new ErrorDataResult<Boolean>();
    }

    @Override
    public Result sendVerificationMail() {
        System.out.println("Doğrulama İşlemi İçin Lütfen E-Posta Adresinize Gönderilen Bağlantıya Tıklayınız.");
        return new SuccessResult();
    }

    @Override
    public Result verifiedUser() {
        System.out.println("Doğrulama İşlemi Başarı İle Sonuçlanmıştır!");
        return new SuccessResult();
    }
}

package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.webServices.hrmsVerifications.HrmsVerificationManager;
import org.springframework.stereotype.Service;

@Service
public class HrmsManagerAdapter implements HrmsService {
    private HrmsVerificationManager hrmsVerificationManager = new HrmsVerificationManager();

    @Override
    public boolean checkForIdentityNumber(String identityNumber) {
        return this.hrmsVerificationManager.emptyCheckerForUser(identityNumber);
    }

}

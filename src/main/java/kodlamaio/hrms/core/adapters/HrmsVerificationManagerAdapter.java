package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.hrmsVerifications.HrmsVerificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrmsVerificationManagerAdapter implements HrmsVerificationService {
    private HrmsVerificationManager hrmsVerificationManager;

    @Autowired
    public HrmsVerificationManagerAdapter(HrmsVerificationManager hrmsVerificationManager) {
        this.hrmsVerificationManager = hrmsVerificationManager;
    }

    @Override
    public boolean CheckForIdentityNumber(String identityNumber) {
        return this.hrmsVerificationManager.emptyCheckerForUser(identityNumber);
    }
}

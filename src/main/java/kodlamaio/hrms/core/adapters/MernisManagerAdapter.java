package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.webServices.mernisService.QMQKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MernisManagerAdapter implements MernisService {
    private QMQKPSPublicSoap qmqkpsPublicSoap = new QMQKPSPublicSoap();

    @Override
    public boolean checkForCandidate(Candidate candidate) {
        try{
           return this.qmqkpsPublicSoap.TCKimlikNoDogrula(
                   Long.valueOf(candidate.getIdentityNumber()),
                   candidate.getFirstName().toUpperCase(Locale.ROOT),
                   candidate.getLastName().toUpperCase(Locale.ROOT),
                   candidate.getYearOfBirth().getYear());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

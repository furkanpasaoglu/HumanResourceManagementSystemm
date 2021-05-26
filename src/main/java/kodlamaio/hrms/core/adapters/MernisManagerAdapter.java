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
                   candidate.getFirst_name().toUpperCase(Locale.ROOT),
                   candidate.getLast_name().toUpperCase(Locale.ROOT),
                   candidate.getYear_of_birth().getYear());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

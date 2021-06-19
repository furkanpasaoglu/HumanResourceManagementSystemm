package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidator {
    public static boolean Validator(Candidate candidate) {
        if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() || candidate.getIdentityNumber().isEmpty() || candidate.getYearOfBirth()==null){
            return false;
        }
        return true;
    }
}

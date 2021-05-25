package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidator {
    public static boolean Validator(Candidate candidate) {
        if(candidate.getFirst_name().isEmpty() || candidate.getLast_name().isEmpty() || candidate.getIdentity_number().isEmpty() || candidate.getYear_of_birth()==null){
            return false;
        }
        return true;
    }
}

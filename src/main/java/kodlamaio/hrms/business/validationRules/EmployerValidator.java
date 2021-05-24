package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {
    public static boolean Validator(Employer employer){
        if(employer.getWebsite().isEmpty() && employer.getCompany_name().isEmpty() && employer.getPhone().isEmpty()){
            System.out.println("Lütfen Boş Alan Bırakmayınız");
            return false;
        }
        return true;
    }
}

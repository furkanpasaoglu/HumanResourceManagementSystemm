package kodlamaio.hrms.webServices.hrmsVerifications;

public class HrmsVerificationManager {
    public boolean emptyCheckerForUser(String identityNumber){
        if(identityNumber.length()<=11 && identityNumber.length()>10){
            return true;
        }else{
            return false;
        }
    }
}

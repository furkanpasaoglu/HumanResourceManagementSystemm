package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.User;

public class UserValidator {
    public static boolean Validator(User user) {
        if(user.getEmail() == null && user.getPassword()==null && user.getConfirm_password() == null){
            System.out.println("Lütfen Boş Alan Bırakmayınız veya Şifreler Uyumlu Değil Lütfen Kontrol Ediniz.");
            return false;
        }
        return true;
    }
}

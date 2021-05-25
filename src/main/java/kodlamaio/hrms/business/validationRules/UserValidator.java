package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.User;

public class UserValidator {
    public static boolean Validator(User user) {
        if (!user.getEmail().isEmpty() && !user.getPassword().isEmpty() && !user.getConfirm_password().isEmpty()) {
            if (user.getPassword().length() > 0 && user.getConfirm_password().length() > 0 && user.getPassword().equals(user.getConfirm_password()))
                return true;
            return false;
        }
        return false;
    }
}

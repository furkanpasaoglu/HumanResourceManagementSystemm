package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.User;

public class UserValidator {
    public static boolean Validator(User user) {
        if (!user.getEmail().isEmpty() && !user.getPassword().isEmpty() && !user.getConfirmPassword().isEmpty()) {
            if (user.getPassword().length() > 0 && user.getConfirmPassword().length() > 0 && user.getPassword().equals(user.getConfirmPassword()))
                return true;
            return false;
        }
        return false;
    }
}

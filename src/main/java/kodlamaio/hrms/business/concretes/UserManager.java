package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result register(User user) {
        var result = BusinessRules.run(checkForUser(user));
        if(result !=null)
            return new ErrorResult("Lütfen Boş Alanları Doldurunuz");

        this.userDao.save(user);
        return new SuccessResult("Başarıyla Kaydedildi.");
    }

    private Result checkForUser(User user){
        if(user.getPassword()==user.getConfirm_password()){
            return new SuccessResult();
        }
        return new ErrorResult();
    }
}

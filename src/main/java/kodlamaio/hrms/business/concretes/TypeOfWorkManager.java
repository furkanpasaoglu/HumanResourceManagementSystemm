package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.TypeOfWorkService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TypeOfWorkDao;
import kodlamaio.hrms.entities.concretes.TypeOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {
    private TypeOfWorkDao typeOfWorkDao;

    @Autowired
    public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
        this.typeOfWorkDao = typeOfWorkDao;
    }

    @Override
    public Result add(TypeOfWork typeOfWork) {
        this.typeOfWorkDao.save(typeOfWork);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<TypeOfWork>> getAll() {
        return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<TypeOfWork> getById(int id) {
        return new SuccessDataResult<TypeOfWork>(this.typeOfWorkDao.getOne(id),Messages.Listed);
    }
}

package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.helpers.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDao;
    private ImageService imageService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,ImageService imageService) {
        this.resumeDao = resumeDao;
        this.imageService = imageService;
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<Resume>> findByResumeId(int id) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findByCandidateId(id),Messages.Listed);
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),Messages.Listed);
    }

    @Override
    public Result addImage(int id, MultipartFile file) {
        Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        Resume resume = this.resumeDao.getOne(id);
        resume.setImageUrl(result.get("url"));
        this.resumeDao.save(resume);
        return new SuccessResult("Başarıyla eklendi");
    }
}

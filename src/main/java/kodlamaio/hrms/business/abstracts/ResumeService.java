package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {
    Result add(Resume resume);
    DataResult<List<Resume>> findByResumeId(int id);
    DataResult<List<Resume>> getAll();
    Result addImage(int id, MultipartFile file);
}

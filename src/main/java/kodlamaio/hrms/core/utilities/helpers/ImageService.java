package kodlamaio.hrms.core.utilities.helpers;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
     DataResult<?> save(MultipartFile file);
}

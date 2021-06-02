package kodlamaio.hrms.core.utilities.helpers;

import com.cloudinary.Cloudinary;
import com.cloudinary.provisioning.Account;
import com.cloudinary.provisioning.AccountConfiguration;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements ImageService{
    Cloudinary cloudinary;
    public CloudinaryManager() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "",
                "api_key", "",
                "api_secret", ""
        ));
    }


    @Override
    public DataResult<?> save(MultipartFile file) {
        Map result;
        try{
            result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        } catch(IOException e){
            e.printStackTrace();
            return new ErrorDataResult<Map>(e.getMessage());
        }
        return new SuccessDataResult<Map>(result);
    }
}

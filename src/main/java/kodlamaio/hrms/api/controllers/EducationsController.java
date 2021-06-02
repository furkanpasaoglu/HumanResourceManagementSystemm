package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @GetMapping("/findAllByOrderByGraduationDateAsc")
    public DataResult<List<Education>> findAllByOrderByGraduationDateAsc(){
        return this.educationService.findAllByOrderByGraduationDateAsc();
    }

    @GetMapping("/findAllByOrderByGraduationDateDesc")
    public DataResult<List<Education>> findAllByOrderByGraduationDateDesc(){
        return this.educationService.findAllByOrderByGraduationDateDesc();
    }
}

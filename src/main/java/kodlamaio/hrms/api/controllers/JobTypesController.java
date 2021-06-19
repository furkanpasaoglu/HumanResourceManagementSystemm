package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobTypes")
@CrossOrigin
public class JobTypesController {
    private JobTypeService jobTypeService;

    @Autowired
    public JobTypesController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobType>> getAll(){
        return this.jobTypeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobType> getById(int id){
        return this.jobTypeService.getById(id);
    }

}

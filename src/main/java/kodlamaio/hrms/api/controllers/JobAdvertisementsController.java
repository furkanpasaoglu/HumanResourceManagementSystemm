package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobAdvertisement> getById(@RequestParam int id){
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("/findByActiveTrue")
    public DataResult<List<JobAdvertisement>> findByActiveTrue(){
        return this.jobAdvertisementService.findByActiveTrue();
    }

    @GetMapping("/findByActiveTrueAndCreateDateAsc")
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndCreateDateAsc(){
        return this.jobAdvertisementService.findByActiveTrueAndCreateDateAsc();
    }

    @GetMapping("/findByActiveTrueOrderByCreateDateDesc")
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc(){
        return this.jobAdvertisementService.findByActiveTrueOrderByCreateDateDesc();
    }

    @GetMapping("/findByActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(int employerId){
        return this.jobAdvertisementService.findByActiveTrueAndEmployer(employerId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.update(jobAdvertisement);
    }
}

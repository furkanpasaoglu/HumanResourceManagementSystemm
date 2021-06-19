package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {

    @Id
    @Column(name = "job_advertisement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobAdvertisementId;

    @Column(name = "description")
    private String description;

    @Column(name = "salary_min")
    private int salaryMin;

    @Column(name = "salary_max")
    private int salaryMax;

    @Column(name = "number_of_open_job_position")
    private String numberOfOpenJobPosition;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "type_of_work_id")
    private TypeOfWork typeOfWork;

    @ManyToOne()
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

}

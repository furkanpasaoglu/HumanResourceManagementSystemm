package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_position_id")
    private int jobPositionId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvertisement> jobAdvertisements;
}

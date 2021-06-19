package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_of_works")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class TypeOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int typeOfWorkId;

    @Column(name = "name")
    private String typeOfWorkName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "typeOfWork")
    private List<JobAdvertisement> jobAdvertisements;
}

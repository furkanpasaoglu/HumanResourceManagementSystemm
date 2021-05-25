package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name ="employers")
public class Employer extends User {

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "website")
    private String website;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "active")
    private boolean active;
}

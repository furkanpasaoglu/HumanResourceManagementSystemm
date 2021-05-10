package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "verifications")
public class Verification {
    @Id
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "confirm")
    private boolean confirm;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "active")
    private boolean active;
}

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
@Table(name = "foreign_languages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foreign_language_id")
    private int foreignLanguageId;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private String languageLevel;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "foreignLanguage")
    private List<Resume> resumes;
}

package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "resumes")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    @Id
    @Column(name = "resume_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resumeId;

    //@Column(name = "education_id")
    //private int educationId;

    //@Column(name = "work_experience_id")
    //private int workExperienceId;

    //@Column(name = "foreign_languages_id")
    //private int foreignLanguagesId;

    //@Column(name = "technologies_id")
    //private int technologiesId;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

    @ManyToOne()
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne()
    @JoinColumn(name = "technology_id")
    private Technology technology;

    @ManyToOne()
    @JoinColumn(name = "work_experience_id")
    private WorkExperience workExperience;

    @ManyToOne()
    @JoinColumn(name = "foreign_language_id")
    private ForeignLanguage foreignLanguage;

}

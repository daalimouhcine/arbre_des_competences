package com.brief.arbre_des_competences.competence;

import com.brief.arbre_des_competences.skillsReference.ReferenceSkillEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "competences")
public class CompetenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    @Basic
    private String name;

    @OneToOne
    @JoinColumn(name = "id_reference", referencedColumnName = "id")
    private ReferenceSkillEntity referenceSkill;

    @OneToMany
    @JoinColumn(name = "id_validate_competence", referencedColumnName = "id")
    private List<ValidateCompetenceEntity> validateCompetences;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReferenceSkillEntity getReferenceSkill() {
        return referenceSkill;
    }

    public void setReferenceSkill(ReferenceSkillEntity referenceSkill) {
        this.referenceSkill = referenceSkill;
    }

    public List<ValidateCompetenceEntity> getValidateCompetences() {
        return validateCompetences;
    }

    public void setValidateCompetences(List<ValidateCompetenceEntity> validateCompetences) {
        this.validateCompetences = validateCompetences;
    }
}

package com.brief.arbre_des_competences.skillsReference;

import com.brief.arbre_des_competences.competence.CompetenceEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "referenceSkills")
public class ReferenceSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column
    @Basic
    private String name;

    @Column
    @Basic
    private String shortname;

    @OneToMany(mappedBy = "referenceSkill")
    private List<CompetenceEntity> competences;

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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public List<CompetenceEntity> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceEntity> competences) {
        this.competences = competences;
    }
}

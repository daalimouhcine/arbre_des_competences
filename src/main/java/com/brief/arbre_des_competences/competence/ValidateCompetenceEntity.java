package com.brief.arbre_des_competences.competence;

import jakarta.persistence.*;

@Entity
@Table(name = "validateComptences")
public class ValidateCompetenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "id_user")
    @Basic
    private long id_user;

    @Column
    @Basic
    private String name;

    @Column
    @Basic
    private int competenceLevel;


    @OneToOne
    @JoinColumn(name = "id_competence", referencedColumnName = "id")
    private CompetenceEntity competence;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompetenceLevel() {
        return competenceLevel;
    }

    public void setCompetenceLevel(int competenceLevel) {
        this.competenceLevel = competenceLevel;
    }

    public CompetenceEntity getCompetence() {
        return competence;
    }

    public void setCompetence(CompetenceEntity competence) {
        this.competence = competence;
    }
}

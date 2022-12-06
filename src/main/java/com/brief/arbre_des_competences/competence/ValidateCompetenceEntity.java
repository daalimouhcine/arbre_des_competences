package com.brief.arbre_des_competences.competence;

import jakarta.persistence.*;

@Entity
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
    private boolean first_level_status;

    @Column
    @Basic
    private boolean second_level_status;

    @Column
    @Basic
    private boolean thire_level_status;

    @Column
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

    public boolean getFirst_level_status() {
        return first_level_status;
    }

    public void setFirst_level_status(boolean first_level_status) {
        this.first_level_status = first_level_status;
    }

    public boolean getSecond_level_status() {
        return second_level_status;
    }

    public void setSecond_level_status(boolean second_level_status) {
        this.second_level_status = second_level_status;
    }

    public boolean getThire_level_status() {
        return thire_level_status;
    }

    public void setThire_level_status(boolean thire_level_status) {
        this.thire_level_status = thire_level_status;
    }

    public CompetenceEntity getCompetence() {
        return competence;
    }

    public void setCompetence(CompetenceEntity competence) {
        this.competence = competence;
    }
}

package com.brief.arbre_des_competences;

import com.brief.arbre_des_competences.competence.CompetenceEntity;
import com.brief.arbre_des_competences.config.EntityManagerConfig;
import com.brief.arbre_des_competences.users.UserEntity;
import com.brief.arbre_des_competences.utils.HashPassword;
import jakarta.persistence.EntityManager;

public class Main{
    public static void main(String[] args) {
        EntityManager em = EntityManagerConfig.getInstance().getEm();
        em.getTransaction().begin();
        UserEntity newUser = new UserEntity();
        newUser.setFirstname("Reda");
        newUser.setLastname("Laghrissi");
        newUser.setClassroom("Brendan Eich");
        newUser.setImage("Reda_Laghrissi");
        newUser.setLevel("A2");
        newUser.setPromotion("2022-2023");
        newUser.setEmail("r.laghrissi@student.youcode.ma");
        newUser.setPassword(HashPassword.hash("123456789"));

        CompetenceEntity newCompetence = new CompetenceEntity();
        newCompetence.setName("Java");
//        newCompetence.;

        em.persist(newUser);
        em.getTransaction().commit();
        em.close();
    }
}

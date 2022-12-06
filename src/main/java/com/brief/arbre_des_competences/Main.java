package com.brief.arbre_des_competences;

import com.brief.arbre_des_competences.config.EntityManagerConfig;
import com.brief.arbre_des_competences.users.UserEntity;
import jakarta.persistence.EntityManager;

public class Main{
    public static void main(String[] args) {
        EntityManager em = EntityManagerConfig.getInstance().getEm();
        em.getTransaction().begin();
        UserEntity newUser = new UserEntity();
        newUser.setFirstname("Mouhcine");
        newUser.setLastname("Daali");
        newUser.setEmail("the.daali.mouhcine@gmail.com");
        newUser.setPassword("123456789");
        newUser.setImage("default");
        newUser.setLevel("A1");
        newUser.setClassroom("Brendan Eich");
        newUser.setPromotion("2022");
        em.persist(newUser);
        em.getTransaction().commit();
        em.close();
    }
}

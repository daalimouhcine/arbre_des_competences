package com.brief.arbre_des_competences.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {
    private EntityManagerFactory emf;
    private static EntityManagerConfig entityManagerConfig = new EntityManagerConfig();

    private EntityManagerConfig() {
        emf = Persistence.createEntityManagerFactory("arbre_des_competences");
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return emf.createEntityManager();
    }

    public static EntityManagerConfig getInstance() {
        return entityManagerConfig;
    }

}

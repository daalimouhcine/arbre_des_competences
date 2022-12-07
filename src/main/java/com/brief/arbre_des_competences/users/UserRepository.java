package com.brief.arbre_des_competences.users;

import com.brief.arbre_des_competences.config.EntityManagerConfig;
import com.brief.arbre_des_competences.utils.Sout;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserRepository {
    public UserEntity getUserByEmail(String email) {
        EntityManager em = EntityManagerConfig.getInstance().getEm();
        try {
            UserEntity user = new UserEntity();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT U FROM UserEntity U where U.email = :email");
            query.setParameter("email", email);
            user = (UserEntity) query.getSingleResult();
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            Sout.sout("red", e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}

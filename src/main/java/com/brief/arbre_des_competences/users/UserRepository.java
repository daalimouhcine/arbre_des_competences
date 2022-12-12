package com.brief.arbre_des_competences.users;

import com.brief.arbre_des_competences.config.EntityManagerConfig;
import com.brief.arbre_des_competences.utils.Sout;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    public UserEntity getUserByEmail(String email) {
        EntityManager em = EntityManagerConfig.getInstance().getEm();
        try {
            UserEntity user = null;
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT U FROM UserEntity U where U.email = :email");
            query.setParameter("email", email);
            user = (UserEntity) query.getSingleResult();
            em.getTransaction().commit();
            return user;

        } catch (Exception e) {
            Sout.sout("blue", e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public List<UserEntity> allUsers() {
        EntityManager em = EntityManagerConfig.getInstance().getEm();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT U FROM UserEntity U");
            List<UserEntity> usersList = query.getResultList();
            em.getTransaction().commit();
            return usersList;
        } catch (Exception e) {
            Sout.sout("red", e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}

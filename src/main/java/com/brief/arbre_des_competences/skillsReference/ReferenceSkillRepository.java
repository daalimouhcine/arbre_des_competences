package com.brief.arbre_des_competences.skillsReference;

import com.brief.arbre_des_competences.config.EntityManagerConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReferenceSkillRepository {

    public List<ReferenceSkillEntity> getAllReferenceSkills() {
            EntityManager em = EntityManagerConfig.getInstance().getEm();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM ReferenceSkillEntity r");
            List<ReferenceSkillEntity> referenceSkillEntities = query.getResultList();
            em.getTransaction().commit();
            return referenceSkillEntities;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}

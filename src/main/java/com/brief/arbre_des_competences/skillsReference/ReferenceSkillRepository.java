package com.brief.arbre_des_competences.skillsReference;

import com.brief.arbre_des_competences.config.EntityManagerConfig;
import com.brief.arbre_des_competences.utils.Sout;
import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReferenceSkillRepository {

    public String allReferenceSkills() {
            EntityManager em = EntityManagerConfig.getInstance().getEm();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT R FROM ReferenceSkillEntity R");
            List<ReferenceSkillEntity> referenceSkillsList = query.getResultList();
            em.getTransaction().commit();
            return new Gson().toJson(referenceSkillsList);
        } catch (Exception e) {
            Sout.sout("red", e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}

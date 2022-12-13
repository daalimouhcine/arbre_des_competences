package com.brief.arbre_des_competences.skillsReference;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceSkillService {
    @Autowired
    private ReferenceSkillRepository referenceSkillRepository;

    public String getAllReferenceSkills() {
        List<ReferenceSkillEntity> referenceSkills = referenceSkillRepository.getAllReferenceSkills();
        return new Gson().toJson(referenceSkills);
    }
}

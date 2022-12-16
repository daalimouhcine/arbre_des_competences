package com.brief.arbre_des_competences.skillsReference;

import com.brief.arbre_des_competences.utils.Sout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/skill")
@CrossOrigin(origins = "*")
public class ReferenceSkillController {
    @Autowired
    private ReferenceSkillService referenceSkillService;

    @GetMapping("/referenceSkills")
    public String getAllReferenceSkills() {
        return referenceSkillService.getAllReferenceSkills();
    }

}

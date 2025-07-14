package com.Skills_Validator.Brief_Service.Services;
import com.Skills_Validator.Brief_Service.Entities.Brief;
import com.Skills_Validator.Brief_Service.Repositories.BriefRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class BriefService {
    private final BriefRepositorie briefRepositorie;
    private final RestTemplate restTemplate;


    public BriefService(BriefRepositorie briefRepositorie, RestTemplate restTemplate) {
        this.briefRepositorie = briefRepositorie;
        this.restTemplate = restTemplate;
    }

    public Optional<Brief> getById(Long id) {
        return briefRepositorie.findById(id);
    }

    public Brief create(Brief brief){
        return briefRepositorie.save(brief);
    }

    public List<Brief> getAll(){
        return briefRepositorie.findAll();
    }

    public Brief assignCompetences(Long briefId, List<Long> competenceIds) {
        String url = "http://localhost:8081/api/competences/validate";

        Boolean isValid = restTemplate.postForObject(url, competenceIds, Boolean.class);
        if (Boolean.FALSE.equals(isValid)) {
            throw new RuntimeException("Compétences invalides !");
        }
        Brief brief = briefRepositorie.findById(briefId).orElseThrow();
        brief.setCompetenceIds(competenceIds);
        return briefRepositorie.save(brief);
    }
}

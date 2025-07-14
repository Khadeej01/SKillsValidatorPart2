package com.Skills_Validator.Brief_Service.Entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contexte;
    private String outils;
    private String livrable;

    @ElementCollection
    private List<Long> competenceIds = new ArrayList<>();


    public Brief(Long id, String contexte, String outils, String livrable , List<Long> competenceIds) {
        this.id = id;
        this.contexte = contexte;
        this.outils = outils;
        this.livrable = livrable;
        this.competenceIds = competenceIds;

    }

    public Brief() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public String getOutils() {
        return outils;
    }

    public void setOutils(String outils) {
        this.outils = outils;
    }

    public String getLivrable() {
        return livrable;
    }

    public void setLivrable(String livrable) {
        this.livrable = livrable;
    }

    public List<Long> getCompetenceIds() {
        return competenceIds;
    }

    public void setCompetenceIds(List<Long> competenceIds) {
        this.competenceIds = competenceIds;
    }
}

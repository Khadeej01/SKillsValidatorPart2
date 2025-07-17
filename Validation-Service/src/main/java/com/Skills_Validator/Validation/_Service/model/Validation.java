package com.Skills_Validator.Validation._Service.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long apprenantId;
    private Long briefId;
    private Long competenceId;
    private Long formateurId;

    private LocalDateTime dateValidation;

    @Enumerated(EnumType.STRING)
    private StatutValidation statut;

    public Validation() {}

    public Validation(Long apprenantId, Long briefId, Long competenceId, Long formateurId, LocalDateTime dateValidation, StatutValidation statut) {
        this.apprenantId = apprenantId;
        this.briefId = briefId;
        this.competenceId = competenceId;
        this.formateurId = formateurId;
        this.dateValidation = dateValidation;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public Long getBriefId() {
        return briefId;
    }

    public void setBriefId(Long briefId) {
        this.briefId = briefId;
    }

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }

    public Long getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(Long formateurId) {
        this.formateurId = formateurId;
    }

    public LocalDateTime getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(LocalDateTime dateValidation) {
        this.dateValidation = dateValidation;
    }

    public StatutValidation getStatut() {
        return statut;
    }

    public void setStatut(StatutValidation statut) {
        this.statut = statut;
    }
}

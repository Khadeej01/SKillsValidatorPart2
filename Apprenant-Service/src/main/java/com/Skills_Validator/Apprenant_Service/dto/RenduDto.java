package com.Skills_Validator.Apprenant_Service.dto;

import java.util.Date;

public class RenduDto {

    private Long id;
    private String message;
    private Date datedepot;
    private String statutRendu;
    private String lien;

    private Long apprenantId;  // Pour lier au DTO Apprenant via son ID

    public RenduDto() {
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public String getStatutRendu() {
        return statutRendu;
    }

    public void setStatutRendu(String statutRendu) {
        this.statutRendu = statutRendu;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }
}

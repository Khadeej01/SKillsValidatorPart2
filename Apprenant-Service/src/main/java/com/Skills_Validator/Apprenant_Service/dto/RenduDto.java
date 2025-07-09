package com.Skills_Validator.Apprenant_Service.dto;

import java.time.LocalDateTime;

public class RenduDto {

        private Long id;
        private Long briefId;
        private Long apprenantId;
        private String contenu;
        private String urlFichier;
        private LocalDateTime dateSoumission;
        private String statut;

        public RenduDto() {}

        public RenduDto(Long briefId, Long apprenantId, String contenu, String urlFichier) {
            this.briefId = briefId;
            this.apprenantId = apprenantId;
            this.contenu = contenu;
            this.urlFichier = urlFichier;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBriefId() {
        return briefId;
    }

    public void setBriefId(Long briefId) {
        this.briefId = briefId;
    }

    public Long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getUrlFichier() {
        return urlFichier;
    }

    public void setUrlFichier(String urlFichier) {
        this.urlFichier = urlFichier;
    }

    public LocalDateTime getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDateTime dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
